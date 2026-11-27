USE college_management;

SELECT department, COUNT(*) AS total_students
FROM students
GROUP BY department;

SELECT department, AVG(marks) AS average_marks
FROM students
GROUP BY department;

SELECT department, MAX(marks) AS highest_marks
FROM students
GROUP BY department;

SELECT department, MIN(marks) AS lowest_marks
FROM students
GROUP BY department;

SELECT department, SUM(marks) AS total_marks
FROM students
GROUP BY department;

SELECT gender, COUNT(*) AS total_students
FROM students
GROUP BY gender;

SELECT student_city, COUNT(*) AS total_students
FROM students
GROUP BY student_city;

SELECT department, AVG(age) AS average_age
FROM students
GROUP BY department;

SELECT student_city, COUNT(*) AS total_students
FROM students
GROUP BY student_city;

SELECT gender, AVG(marks) AS average_marks
FROM students
GROUP BY gender;