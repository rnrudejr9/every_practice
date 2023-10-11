-- 코드를 입력하세요
SELECT
    # *
    p.PRODUCT_ID,
    p.PRODUCT_NAME,
    sum((p.price * f.amount)) as TOTAL_SALES
FROM
   food_order f join  food_product p 
    on p.PRODUCT_ID = f.PRODUCT_ID
    # and YEAR(f.PRODUCE_DATE) = 2022
    # and MONTH(f.PRODUCE_DATE) = 5
WHERE
    YEAR(f.PRODUCE_DATE) = 2022 and MONTH(f.PRODUCE_DATE) = 5

group by p.PRODUCT_NAME
order by TOTAL_SALES desc, p.PRODUCT_ID asc