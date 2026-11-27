USE college_management;

SELECT * FROM students WHERE student_name LIKE 'A%';

SELECT * FROM students WHERE student_name LIKE '%a';

SELECT * FROM students WHERE student_name LIKE '%an%';

SELECT * FROM students WHERE student_name LIKE '_____';

SELECT * FROM students WHERE department IN ('CSE', 'ECE', 'ISE');

SELECT * FROM students WHERE city IN ('Bangalore', 'Chennai', 'Hyderabad');

SELECT * FROM students WHERE marks BETWEEN 70 AND 90;

SELECT * FROM students WHERE age BETWEEN 19 AND 21;

SELECT * FROM students WHERE student_name NOT LIKE 'P%';

SELECT * FROM students WHERE marks NOT BETWEEN 60 AND 80;