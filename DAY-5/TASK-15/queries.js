USE college_management;

SELECT COUNT(*) AS total_students FROM students;

SELECT AVG(marks) AS average_marks FROM students;

SELECT MAX(marks) AS highest_marks FROM students;

SELECT MIN(marks) AS lowest_marks FROM students;

SELECT SUM(marks) AS total_marks FROM students;

SELECT COUNT(*) AS cse_students
FROM students
WHERE department = 'CSE';

SELECT AVG(age) AS average_age FROM students;

SELECT AVG(marks) AS average_female_marks
FROM students
WHERE gender = 'Female';

SELECT COUNT(*) AS bangalore_students
FROM students
WHERE student_city = 'Bangalore';

SELECT MAX(marks) - MIN(marks) AS marks_difference
FROM students;