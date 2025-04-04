SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, GENDER, COUNT(DISTINCT U.USER_ID) AS USERS
FROM ONLINE_SALE S LEFT JOIN USER_INFO U ON S.USER_ID = U.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER
ORDER BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER