SELECT D.ID, COUNT(C.ID) AS CHILD_COUNT
FROM ECOLI_DATA D 
    LEFT JOIN ECOLI_DATA C
    ON D.ID=C.PARENT_ID
GROUP BY D.ID
ORDER BY D.ID