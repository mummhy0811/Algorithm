SELECT
    YEAR(SALES_DATE) AS YEAR, 
    MONTH(SALES_DATE) AS MONTH,
    COUNT(DISTINCT S.USER_ID) AS PURCHASED_USERS,
    ROUND(COUNT(DISTINCT S.USER_ID)/(SELECT COUNT(*)
                                    FROM USER_INFO
                                    WHERE YEAR(JOINED) = 2021), 1) AS PUCHASED_RATIO
FROM ONLINE_SALE S INNER JOIN (
    SELECT USER_ID
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
) U ON S.USER_ID = U.USER_ID
GROUP BY 1, 2
ORDER BY 1, 2