# Write your MySQL query statement below

WITH all_client as (
    SELECT t.id, t.driver_id, t.city_id, t.status, t.request_at
    FROM Trips t
    LEFT JOIN Users u
    ON t.client_id = u.users_id
    WHERE u.banned  != 'Yes'
    AND u.role = 'client'
    #AND request_at <= "2013-10-01" 
    #AND request_at >= "2013-10-03"
),

all_rows AS (
    SELECT ac.id, ac.city_id, ac.status, ac.request_at
    FROM all_client ac
    LEFT JOIN Users u
    ON ac.driver_id = u.users_id
    WHERE u.banned  != 'Yes'
    AND u.role = 'driver'
    #AND request_at <= "2013-10-01" 
    #AND request_at >= "2013-10-03"
),

grouped_by_date AS (
    SELECT 
    request_at, 
    status, 
    COUNT(*) as total_count,
    SUM(CASE WHEN status = 'completed' THEN 1 ELSE 0 END) AS completed_count
    FROM all_rows
    WHERE request_at >= '2013-10-01'
    AND request_at <= '2013-10-03'
    GROUP BY request_at
)

SELECT request_at AS Day, ROUND((total_count - completed_count)/total_count, 2) AS "Cancellation Rate"
FROM grouped_by_date
GROUP BY request_at
ORDER BY request_at