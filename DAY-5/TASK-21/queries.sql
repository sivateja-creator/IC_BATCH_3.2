USE college_management;

-- 1. Display student names with their course names
SELECT s.student_name, sc.course_name
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id;


-- 2. Display all courses selected by student ID 101
SELECT sc.course_name
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
WHERE s.student_id = 101;


-- 3. Display students enrolled in Java
SELECT DISTINCT s.student_name
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
WHERE sc.course_name = 'Java';


-- 4. Display student names with course fees
SELECT s.student_name, sc.course_name, sc.course_fee
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id;


-- 5. Display students enrolled in more than one course
SELECT s.student_name, COUNT(sc.course_id) AS total_courses
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
GROUP BY s.student_id, s.student_name
HAVING COUNT(sc.course_id) > 1;


-- 6. Find the total course fee paid by each student
SELECT s.student_name, SUM(sc.course_fee) AS total_fee
FROM students s
INNER JOIN student_courses sc
ON s.student_id = sc.student_id
GROUP BY s.student_id, s.student_name;


-- 7. Display students who have not enrolled in any course
SELECT s.student_id, s.student_name
FROM students s
LEFT JOIN student_courses sc
ON s.student_id = sc.student_id
WHERE sc.student_id IS NULL;