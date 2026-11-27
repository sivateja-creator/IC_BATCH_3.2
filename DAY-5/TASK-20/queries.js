USE college_management;

SELECT d.department_id, d.department_name, s.student_id, s.student_name
FROM students s
RIGHT JOIN college_departments d
ON s.department_id = d.department_id;

SELECT d.department_id, d.department_name, s.student_name
FROM students s
RIGHT JOIN college_departments d
ON s.department_id = d.department_id;

SELECT d.department_id, d.department_name
FROM students s
RIGHT JOIN college_departments d
ON s.department_id = d.department_id
WHERE s.student_id IS NULL;

SELECT d.department_name, COUNT(s.student_id) AS total_students
FROM students s
RIGHT JOIN college_departments d
ON s.department_id = d.department_id
GROUP BY d.department_id, d.department_name;