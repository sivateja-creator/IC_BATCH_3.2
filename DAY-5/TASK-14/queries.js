USE college_management;

ALTER TABLE students
ADD email VARCHAR(100);

ALTER TABLE students
ADD phone_number VARCHAR(15);

ALTER TABLE students
MODIFY student_name VARCHAR(150);

ALTER TABLE students
MODIFY marks DECIMAL(5,2);

ALTER TABLE students
RENAME COLUMN city TO student_city;

ALTER TABLE students
DROP COLUMN phone_number;

ALTER TABLE students
RENAME TO college_students;

ALTER TABLE college_students
RENAME TO students;

DESC students;