USE college_management;

DELETE FROM students
WHERE student_id = 110;

DELETE FROM students
WHERE department = 'CIVIL';

DELETE FROM students
WHERE marks < 40;

DELETE FROM students
WHERE city = 'Pune';

DELETE FROM students
WHERE age > 22;

SELECT * FROM students;

DELETE FROM students;