-- 코드를 입력하세요
SELECT
USER_ID,PRODUCT_ID
FROM
ONLINE_SALE 


GROUP by USER_ID, PRODUCT_ID
Having count(USER_ID) > 1 and count(PRODUCT_ID) > 1
order by USER_ID asc, PRODUCT_ID desc