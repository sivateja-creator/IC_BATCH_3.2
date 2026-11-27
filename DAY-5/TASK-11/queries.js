USE college_management;

UPDATE students
SET marks = 90
WHERE student_name = 'Rahul';

UPDATE students
SET city = 'Bangalore'
WHERE student_name = 'Sneha';

UPDATE students
SET marks = marks + 5
WHERE department = 'CSE';

UPDATE students
SET department = 'CSE'
WHERE student_id = 105;

UPDATE students
SET age = 21
WHERE age = 20;

UPDATE students
SET city = 'Bangalore'
WHERE city = 'Mysore';

UPDATE students
SET marks = marks + 10
WHERE marks < 70;

UPDATE students
SET department = 'ECE'
WHERE student_id = 107;

SELECT * FROM students;