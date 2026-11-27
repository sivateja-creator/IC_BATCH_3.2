USE college_management;

SELECT * FROM students WHERE department = 'CSE';

SELECT * FROM students WHERE marks > 80;

SELECT * FROM students WHERE age = 20;

SELECT * FROM students WHERE marks <= 75;

SELECT * FROM students WHERE department != 'CSE';

SELECT * FROM students WHERE marks >= 70 AND marks <= 90;

SELECT * FROM students WHERE department = 'CSE' AND marks > 80;

SELECT * FROM students WHERE city = 'Bangalore' OR city = 'Mysore';

SELECT * FROM students WHERE NOT city = 'Hyderabad';

SELECT * FROM students WHERE gender = 'Female' AND marks > 85;