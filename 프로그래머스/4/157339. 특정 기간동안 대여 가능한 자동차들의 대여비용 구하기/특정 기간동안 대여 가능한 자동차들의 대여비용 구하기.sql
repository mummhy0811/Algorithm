select C.CAR_ID, C.CAR_TYPE, FLOOR(C.DAILY_FEE* ((100-DISCOUNT_RATE)*0.01)) * 30 FEE
from 
        (
            select CAR_ID, CAR_TYPE, DAILY_FEE
            FROM CAR_RENTAL_COMPANY_CAR
            WHERE CAR_TYPE like '세단' or CAR_TYPE like 'SUV'
        ) C
        inner join
        (
            select CAR_TYPE, DISCOUNT_RATE
            from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
            where DURATION_TYPE like '30일 이상'
        ) P
        on P.CAR_TYPE = C.CAR_TYPE
where CAR_ID not in (
select distinct CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where MONTH(START_DATE)=11 or (MONTH(END_DATE)=11) or (START_DATE<='2022-11-01' and END_DATE>='2022-11-30')
) and (C.DAILY_FEE* ((100-DISCOUNT_RATE)*0.01)) * 30 >=500000 and (C.DAILY_FEE* ((100-DISCOUNT_RATE)*0.01)) * 30 <2000000
order by FEE desc, C.CAR_TYPE asc, C.CAR_ID desc