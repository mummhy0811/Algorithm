select CART_ID
from CART_PRODUCTS 
where NAME IN ('Milk', 'Yogurt')
group by CART_ID
having count(distinct NAME)=2;