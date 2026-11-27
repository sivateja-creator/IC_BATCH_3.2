USE college_management;

SELECT department, COUNT(*) AS total_students
FROM students
GROUP BY department
HAVING COUNT(*) > 2;

SELECT department, AVG(marks) AS average_marks
FROM students
GROUP BY department
HAVING AVG(marks) > 80;

SELECT student_city, COUNT(*) AS total_students
FROM students
GROUP BY student_city
HAVING COUNT(*) > 1;

SELECT department, MAX(marks) AS highest_marks
FROM students
GROUP BY department
HAVING MAX(marks) > 90;

SELECT department, SUM(marks) AS total_marks
FROM students
GROUP BY department
HAVING SUM(marks) > 200;

SELECT gender, AVG(marks) AS average_marks
FROM students
GROUP BY gender
HAVING AVG(marks) > 80;

SELECT department, COUNT(*) AS total_students, AVG(marks) AS average_marks
FROM students
GROUP BY department
HAVING COUNT(*) >= 3 AND AVG(marks) > 75;