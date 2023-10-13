-- 코드를 입력하세요
SELECT
    animal_type, count(animal_type) as count
FROM
    ANIMAL_INS 
where
    animal_type in ('cat','dog')

GROUP BY
    animal_type
order by
    animal_type
