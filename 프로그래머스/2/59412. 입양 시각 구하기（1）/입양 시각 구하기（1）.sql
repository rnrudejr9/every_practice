-- 코드를 입력하세요
SELECT
    HOUR(DATETIME) as HOUR, count(HOUR(DATETIME))
from
    animal_outs
group by HOUR
having HOUR between 9 and 19
order by HOUR asc
                
