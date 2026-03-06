SELECT
    he.EMP_NO,
    he.EMP_NAME,
    CASE
        WHEN AVG(hg.SCORE) >= 96 THEN 'S'
        WHEN AVG(hg.SCORE) >= 90 THEN 'A'
        WHEN AVG(hg.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END GRADE,
    CASE
        WHEN AVG(hg.SCORE) >= 96 THEN he.SAL * 20 / 100
        WHEN AVG(hg.SCORE) >= 90 THEN he.SAL * 15 / 100
        WHEN AVG(hg.SCORE) >= 80 THEN he.SAL * 10 / 100
        ELSE 0
    END BONUS
FROM HR_EMPLOYEES he
JOIN HR_GRADE hg USING (EMP_NO)
GROUP BY hg.EMP_NO
ORDER BY EMP_NO