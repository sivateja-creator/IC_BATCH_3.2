USE college_management;

-- 1. Display all student details with department information
SELECT s.*, d.department_name, d.hod_name
FROM students s
LEFT JOIN departments d
ON s.department_id = d.department_id;


-- 2. Display all student names with their enrolled courses
SELECT s.student_name, sc.course_name
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id;


-- 3. Display students who are not enrolled in any course
SELECT s.student_id, s.student_name
FROM students s
LEFT JOIN student_courses sc
ON s.student_id = sc.student_id
WHERE sc.student_id IS NULL;


-- 4. Display departments without any registered students
SELECT d.department_id, d.department_name
FROM departments d
LEFT JOIN students s
ON d.department_id = s.department_id
WHERE s.student_id IS NULL;


-- 5. Display the total number of students in each department
SELECT d.department_name, COUNT(s.student_id) AS total_students
FROM departments d
LEFT JOIN students s
ON d.department_id = s.department_id
GROUP BY d.department_id, d.department_name;


-- 6. Display the total course fee collected from each department
SELECT d.department_name,
       COALESCE(SUM(sc.course_fee), 0) AS total_fees
FROM departments d
LEFT JOIN students s
ON d.department_id = s.department_id
LEFT JOIN student_courses sc
ON s.student_id = sc.student_id
GROUP BY d.department_id, d.department_name;


-- 7. Display the department with the highest number of students
SELECT d.department_name, COUNT(s.student_id) AS total_students
FROM departments d
LEFT JOIN students s
ON d.department_id = s.department_id
GROUP BY d.department_id, d.department_name
ORDER BY total_students DESC
LIMIT 1;


-- 8. Display the department with the highest average student marks
SELECT d.department_name, AVG(s.marks) AS average_marks
FROM departments d
INNER JOIN students s
ON d.department_id = s.department_id
GROUP BY d.department_id, d.department_name
ORDER BY average_marks DESC
LIMIT 1;


-- 9. Display the top five students with their department names
SELECT s.student_name, s.marks, d.department_name
FROM students s
LEFT JOIN departments d
ON s.department_id = d.department_id
ORDER BY s.marks DESC
LIMIT 5;


-- 10. Generate a complete student course report
SELECT s.student_name,
       d.department_name,
       d.hod_name,
       sc.course_name,
       sc.course_fee
FROM students s
INNER JOIN departments d
ON s.department_id = d.department_id
INNER JOIN student_courses sc
ON s.student_id = sc.student_id;