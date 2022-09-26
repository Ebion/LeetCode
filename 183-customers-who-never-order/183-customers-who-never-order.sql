# Write your MySQL query statement below

SELECT NAME AS Customers
FROM CUSTOMERS C
WHERE C.ID NOT IN (SELECT C.ID
FROM CUSTOMERS C, ORDERS O
WHERE O.CUSTOMERID = C.ID)
