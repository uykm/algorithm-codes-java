-- 1. Front End 스킬 코드의 합을 구하기 위한 서브쿼리 활용
WITH FE AS (
    SELECT SUM(CODE) AS CODE_SUM
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
)

SELECT 
    CASE 
        -- A: Front End 스킬이 있고, Python(256) 스킬이 있는 경우
        WHEN (SKILL_CODE & (SELECT CODE_SUM FROM FE)) > 0 
             AND (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')) > 0 THEN 'A'
        
        -- B: C#(1024) 스킬이 있는 경우
        WHEN (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')) > 0 THEN 'B'
        
        -- C: Front End 스킬이 있는 경우 (A 제외는 CASE문의 순서로 자동 처리)
        WHEN (SKILL_CODE & (SELECT CODE_SUM FROM FE)) > 0 THEN 'C'
    END AS GRADE,
    ID,
    EMAIL
FROM DEVELOPERS
-- GRADE가 부여된 개발자만 조회 (NULL 제외)
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID;