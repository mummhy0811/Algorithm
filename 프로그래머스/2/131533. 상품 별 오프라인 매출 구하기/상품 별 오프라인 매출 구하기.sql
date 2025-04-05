SELECT P.PRODUCT_CODE, S.SUM*P.PRICE AS SALES
FROM (
    SELECT PRODUCT_ID, SUM(SALES_AMOUNT) AS SUM
    FROM OFFLINE_SALE
    GROUP BY PRODUCT_ID
) S INNER JOIN PRODUCT P ON S.PRODUCT_ID = P.PRODUCT_ID
ORDER BY 2 DESC, P.PRODUCT_CODE ASC