USE college_management;

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    department VARCHAR(50),
    city VARCHAR(50),
    marks DECIMAL(5,2),
    admission_date DATE
);

DESC students;

SHOW TABLES;

CREATE TABLE teachers (
    teacher_id INT PRIMARY KEY,
    teacher_name VARCHAR(100),
    subject VARCHAR(50),
    salary DECIMAL(10,2),
    department VARCHAR(50)
);

SHOW TABLES;

DESC teachers;