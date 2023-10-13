-- 코드를 입력하세요
SELECT
    b.category, sum(s.sales) as total
FROM
    book b left join book_sales s
    on b.BOOK_ID = s.BOOK_ID
where
    date_format(s.sales_date,"%Y-%m") = '2022-01'
GROUP BY
    b.category
ORDER BY
    b.category asc
    