USE college_management;

SELECT * FROM students ORDER BY student_name ASC;

SELECT * FROM students ORDER BY marks DESC;

SELECT * FROM students ORDER BY age ASC;

SELECT * FROM students ORDER BY department ASC;

SELECT * FROM students ORDER BY marks DESC LIMIT 3;

SELECT * FROM students ORDER BY marks ASC LIMIT 1;

SELECT * FROM students LIMIT 5;

SELECT * FROM students ORDER BY marks DESC LIMIT 5;

SELECT * FROM students
WHERE department = 'CSE'
ORDER BY marks DESC
LIMIT 3;

SELECT * FROM students
ORDER BY department ASC, marks DESC;