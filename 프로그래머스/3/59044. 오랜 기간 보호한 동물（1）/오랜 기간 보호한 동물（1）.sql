-- 코드를 입력하세요
SELECT a.NAME, a.DATETIME
FROM animal_ins a left join animal_outs b
    on a.ANIMAL_ID = b.ANIMAL_ID
where b.ANIMAL_ID is null
order by a.DATETIME asc limit 3