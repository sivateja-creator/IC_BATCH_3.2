USE college_management;

SELECT s.student_id, s.student_name, d.department_name
FROM students s
LEFT JOIN college_departments d
ON s.department_id = d.department_id;

SELECT s.student_id, s.student_name, s.department, d.department_name
FROM students s
LEFT JOIN college_departments d
ON s.department_id = d.department_id;

SELECT s.student_id, s.student_name, s.department_id
FROM students s
LEFT JOIN college_departments d
ON s.department_id = d.department_id
WHERE d.department_id IS NULL;

SELECT s.student_id, s.student_name, d.department_name, d.hod_name
FROM students s
LEFT JOIN college_departments d
ON s.department_id = d.department_id;