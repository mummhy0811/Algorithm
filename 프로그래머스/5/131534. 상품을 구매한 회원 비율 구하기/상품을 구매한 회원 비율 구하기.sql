set @user_cnt = (
    select count(*) from USER_INFO where YEAR(JOINED)='2021'
);

SELECT YEAR(SALES_DATE) YEAR,  MONTH(SALES_DATE) MONTH, count(distinct O.user_id ) PURCHASED_USERS,  ROUND(count(distinct O.user_id )/@user_cnt, 1) PUCHASED_RATIO
FROM ONLINE_SALE O
inner join(
    select USER_ID
    from USER_INFO
    where YEAR(JOINED)='2021'
) U on O.USER_ID=U.USER_ID
GROUP BY YEAR(O.SALES_DATE) , MONTH(O.SALES_DATE)
ORDER BY YEAR(O.SALES_DATE) , MONTH(O.SALES_DATE);