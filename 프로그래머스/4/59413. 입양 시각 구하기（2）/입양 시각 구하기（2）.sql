WITH RECURSIVE
    RECUR AS (
        SELECT 0 AS HOUR
        
        UNION ALL
        
        SELECT HOUR + 1
        FROM RECUR
        WHERE HOUR < 23
    ),
    CNT AS (
        SELECT
            HOUR(DATETIME) AS HOUR,
            COUNT(*) AS COUNT
        FROM ANIMAL_OUTS
        GROUP BY HOUR
    )
SELECT
    HOUR,
    IFNULL(COUNT, 0)
FROM
    RECUR
LEFT JOIN
    CNT USING (HOUR)
ORDER BY
    HOUR;