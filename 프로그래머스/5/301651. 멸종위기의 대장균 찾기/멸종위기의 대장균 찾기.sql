WITH RECURSIVE 
    CHILDS AS (
        SELECT
            ID,
            PARENT_ID,
            1 AS GENER
        FROM ECOLI_DATA
        WHERE PARENT_ID IS NULL

        UNION ALL

        SELECT
            ed.ID,
            ed.PARENT_ID,
            GENER + 1 AS GENER
        FROM CHILDS c
        JOIN ECOLI_DATA ed
            ON ed.PARENT_ID = c.ID
    )
SELECT
    COUNT(p.ID) AS COUNT,
    p.GENER AS GENERATION
FROM CHILDS p
WHERE NOT EXISTS (
    SELECT 1
    FROM CHILDS c
    WHERE p.ID = c.PARENT_ID
)
GROUP BY GENERATION
ORDER BY GENERATION