# Write your MySQL query statement below
SELECT E.NAME AS "Employee"
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE E2
ON E.MANAGERID = E2.ID
WHERE E.SALARY > E2.SALARY;