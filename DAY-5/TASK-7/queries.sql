USE college_management;

SELECT * FROM students;

SELECT student_name FROM students;

SELECT student_name, marks FROM students;

SELECT student_id, student_name, department FROM students;

SELECT DISTINCT department FROM students;

SELECT DISTINCT city FROM students;

SELECT DISTINCT department, city FROM students;

SELECT student_name AS Name FROM students;

SELECT marks AS Student_Marks FROM students;