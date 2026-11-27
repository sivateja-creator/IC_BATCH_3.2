USE college_management;

-- 1. Display student name, department name, and course name
SELECT s.student_name, d.department_name, sc.course_name
FROM students s
INNER JOIN departments d
ON s.department_id = d.department_id
INNER JOIN student_courses sc
ON s.student_id = sc.student_id;


-- 2. Display student name, HOD name, and course fee
SELECT s.student_name, d.hod_name, sc.course_fee
FROM students s
INNER JOIN departments d
ON s.department_id = d.department_id
INNER JOIN student_courses sc
ON s.student_id = sc.student_id;


-- 3. Display all CSE students enrolled in Java
SELECT s.student_name
FROM students s
INNER JOIN departments d
ON s.department_id = d.department_id
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
WHERE d.department_name = 'CSE'
AND sc.course_name = 'Java';


-- 4. Display department-wise course enrollment counts
SELECT d.department_name, COUNT(sc.course_id) AS total_enrollments
FROM departments d
INNER JOIN students s
ON d.department_id = s.department_id
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
GROUP BY d.department_id, d.department_name;


-- 5. Display students who enrolled in courses costing more than 4000
SELECT DISTINCT s.student_name, sc.course_name, sc.course_fee
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
WHERE sc.course_fee > 4000;


-- 6. Calculate total course fees collected by each department
SELECT d.department_name, SUM(sc.course_fee) AS total_fees
FROM departments d
INNER JOIN students s
ON d.department_id = s.department_id
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
GROUP BY d.department_id, d.department_name;