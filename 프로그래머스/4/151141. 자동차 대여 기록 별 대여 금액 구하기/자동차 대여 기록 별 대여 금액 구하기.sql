-- 코드를 입력하세요
SELECT H.HISTORY_ID, CONVERT(
(
CASE
    WHEN DATEDIFF(H.END_DATE,H.START_DATE)+1>=90 THEN 1-0.01*(SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN P WHERE P.CAR_TYPE = C.CAR_TYPE AND P.DURATION_TYPE like '90일 이상')
    WHEN  DATEDIFF(H.END_DATE,H.START_DATE)+1>=30 THEN 1-0.01*(SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN P WHERE P.CAR_TYPE = C.CAR_TYPE AND P.DURATION_TYPE like '30일 이상')
    WHEN  DATEDIFF(H.END_DATE,H.START_DATE)+1>=7 THEN 1-0.01*(SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN P WHERE P.CAR_TYPE = C.CAR_TYPE AND P.DURATION_TYPE like '7일 이상')
    ELSE 1
END
)* (DATEDIFF(H.END_DATE,H.START_DATE)+1)*C.DAILY_FEE, UNSIGNED) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
LEFT JOIN CAR_RENTAL_COMPANY_CAR C
ON H.CAR_ID=C.CAR_ID
WHERE C.CAR_TYPE like "트럭"
ORDER BY FEE DESC, H.HISTORY_ID DESC;