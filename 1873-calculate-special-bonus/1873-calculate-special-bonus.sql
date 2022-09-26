# Write your MySQL query statement below
SELECT employee_id, 
    CASE 
    WHEN NAME NOT LIKE 'M%' AND EMPLOYEE_ID%2 = 1 THEN SALARY
ELSE 0
END AS 'bonus'
FROM EMPLOYEES E
ORDER BY EMPLOYEE_ID ASC;

#SELECT employee_id, 
#    CASE 
#    WHEN employee_id%2=1 AND name NOT LIKE 'M%' THEN salary 
#    ELSE 0 
#    END 
#AS bonus FROM Employees;