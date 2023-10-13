-- 코드를 입력하세요

select 
    USER_ID,NICKNAME,TOTAL_SALES
from 
    (SELECT
        u.USER_ID,u.NICKNAME, sum(price) as TOTAL_SALES
    FROM
        USED_GOODS_BOARD b left join USED_GOODS_USER u
        on b.WRITER_ID = u.USER_ID
    where 
        b.status = 'done'
    group by
        u.user_id ) as t
where
    TOTAL_SALES >= 700000
order by TOTAL_SALES asc
