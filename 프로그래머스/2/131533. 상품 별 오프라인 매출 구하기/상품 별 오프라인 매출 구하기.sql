-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(s.sales_amount * p.price) as SALES
FROM product p left join offline_sale s
    on p.PRODUCT_ID = s.PRODUCT_ID
group by p.product_code
order by SALES desc, p.PRODUCT_CODE asc
