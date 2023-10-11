-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.NAME
from animal_outs a left join animal_ins b
on a.ANIMAL_ID = b.ANIMAL_ID
where b.ANIMAL_ID is null