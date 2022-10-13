# Write your MySQL query statement below
SELECT EMAIL
FROM PERSON P
GROUP BY EMAIL
HAVING COUNT(*) > 1;