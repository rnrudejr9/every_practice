-- 코드를 입력하세요
SELECT
i.Ingredient_type,sum(f.total_order) as TOTAL_ORDER
FROM
    FIRST_HALF f left join ICECREAM_INFO i
    on f.FLAVOR = i.FLAVOR

GROUP BY i.INGREDIENT_TYPE