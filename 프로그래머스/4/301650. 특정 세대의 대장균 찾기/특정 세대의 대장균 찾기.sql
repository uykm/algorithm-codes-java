WITH RECURSIVE
    GEN AS (
        SELECT
            ID,
            1 AS GENER
        FROM ECOLI_DATA
        WHERE PARENT_ID IS NULL
        
        UNION ALL
        
        SELECT
            ED.ID,
            GEN.GENER + 1 AS GENER
        FROM GEN
        JOIN ECOLI_DATA ED ON GEN.ID = ED.PARENT_ID
        WHERE GEN.GENER < 3
    )
SELECT ID
FROM GEN
WHERE GENER = 3
ORDER BY ID;
