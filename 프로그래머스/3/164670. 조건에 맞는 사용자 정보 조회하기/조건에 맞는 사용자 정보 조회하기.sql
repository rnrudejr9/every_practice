-- 코드를 입력하세요
SELECT
u.USER_ID,
u.NICKNAME,
concat(u.city," ",u.STREET_ADDRESS1," ",u.STREET_ADDRESS2) as '전체주소',
concat(subString(u.TLNO,1,3),"-",subString(u.TLNO,4,4),"-",subString(u.TLNO,8,4)) as '전화번호'
from
    USED_GOODS_BOARD b left join USED_GOODS_USER u
    on b.WRITER_ID = u.USER_ID
group by b.writer_id
having count(b.writer_id) >= 3
order by u.user_id desc