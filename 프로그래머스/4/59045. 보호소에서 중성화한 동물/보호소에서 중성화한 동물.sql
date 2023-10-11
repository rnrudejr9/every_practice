-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME
FROM animal_ins a left join animal_outs b
    on a.ANIMAL_ID = b.ANIMAL_ID
where a.SEX_UPON_INTAKE != b.SEX_UPON_OUTCOME