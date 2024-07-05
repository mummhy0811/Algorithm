select FLAVOR
from (
select *
from FIRST_HALF
union all (
    select *
    from JULY
)) as total
group by flavor
order by sum(total_order) desc
limit 3;

# select * from first_half;
# select * from july;
# select shipment_id, flavor, sum(total_order) from july group by flavor;