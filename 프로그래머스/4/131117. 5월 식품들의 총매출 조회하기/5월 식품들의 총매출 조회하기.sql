SELECT 
    F.PRODUCT_ID, 
    F.PRODUCT_NAME, 
    F.PRICE * O.total AS TOTAL_SALES
FROM 
    FOOD_PRODUCT F
JOIN 
    (
        SELECT 
            PRODUCT_ID, 
            SUM(AMOUNT) AS total
        FROM 
            FOOD_ORDER
        WHERE 
            PRODUCE_DATE LIKE '2022-05%'
        GROUP BY 
            PRODUCT_ID
    ) O ON F.PRODUCT_ID = O.PRODUCT_ID
ORDER BY 
    TOTAL_SALES DESC, 
    F.PRODUCT_ID ASC;