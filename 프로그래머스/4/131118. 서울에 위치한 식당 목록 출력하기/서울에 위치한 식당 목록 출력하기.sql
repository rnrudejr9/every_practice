-- 코드를 입력하세요
SELECT
a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, 
ROUND(AVG(b.REVIEW_SCORE),2) as SCORE
FROM
REST_INFO a left join REST_REVIEW b
on a.REST_ID = b.REST_ID
where a.ADDRESS like '서울%'
and b.REST_ID is not null
group by a.REST_ID
order by SCORE desc, a.FAVORITES desc