select CART_ID
from (
    SELECT distinct CART_ID
    FROM CART_PRODUCTS 
    where CART_PRODUCTS.NAME like 'Yogurt'
        union all
    SELECT distinct CART_ID
    FROM CART_PRODUCTS 
    where CART_PRODUCTS.NAME like 'Milk'
)UNIONED_CART
group by CART_ID
having count(cart_id)>=2