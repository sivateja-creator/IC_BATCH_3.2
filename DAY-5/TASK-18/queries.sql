USE college_management;

CREATE TABLE college_departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50),
    hod_name VARCHAR(100)
);

INSERT INTO college_departments VALUES
(1, 'CSE', 'Mr. Kumar'),
(2, 'ECE', 'Mrs. Lakshmi'),
(3, 'ISE', 'Mr. Raj'),
(4, 'MECH', 'Mr. Anand'),
(5, 'CIVIL', 'Mrs. Priya');

CREATE TABLE student_courses (
    course_id INT PRIMARY KEY,
    student_id INT,
    course_name VARCHAR(100),
    fee DECIMAL(10,2)
);

INSERT INTO student_courses VALUES
(201, 101, 'Java', 5000),
(202, 102, 'Python', 4500),
(203, 103, 'Java', 5000),
(204, 104, 'Web Development', 6000),
(205, 106, 'Python', 4500),
(206, 101, 'SQL', 3000);

ALTER TABLE students
ADD department_id INT;

UPDATE students
SET department_id = CASE
    WHEN department = 'CSE' THEN 1
    WHEN department = 'ECE' THEN 2
    WHEN department = 'ISE' THEN 3
    WHEN department = 'MECH' THEN 4
    WHEN department = 'CIVIL' THEN 5
    ELSE NULL
END;

SELECT s.student_name, d.department_name
FROM students s
INNER JOIN college_departments d
ON s.department_id = d.department_id;

SELECT s.student_id, s.student_name, d.hod_name
FROM students s
INNER JOIN college_departments d
ON s.department_id = d.department_id;

SELECT s.*
FROM students s
INNER JOIN college_departments d
ON s.department_id = d.department_id
WHERE d.department_name = 'CSE';

SELECT s.student_id, s.student_name, d.department_id, d.department_name, d.hod_name
FROM students s
INNER JOIN college_departments d
ON s.department_id = d.department_id;

SELECT s.student_id, s.student_name, d.department_name
FROM students s
INNER JOIN college_departments d
ON s.department_id = d.department_id
WHERE d.department_name IN ('ECE', 'ISE');