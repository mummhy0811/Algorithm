SELECT DISTINCT CAR_ID, IF(RENTED IS NULL , '대여 가능', '대여중')
AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H LEFT OUTER JOIN(
    SELECT CAR_ID AS RENTED
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
        WHERE (START_DATE<='2022-10-16' AND END_DATE>='2022-10-16')
    ORDER BY CAR_ID
) AS C
ON H.CAR_ID = C.RENTED
ORDER BY CAR_ID DESC
