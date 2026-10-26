# Write your MySQL query statement below
SELECT e.name as Employee from Employee e join Employee m ON e.managerId = m.id
WHERE e.salary > m.salary;
