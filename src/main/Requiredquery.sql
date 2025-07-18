use studentmanagement;

select * from student_course where 
grade > ( select avg(grade) from student_course );

select avg(grade) from student_course;

select c_id, avg(grade) from student_course group by c_id;

select c_id , count(s_id) from student_course group by c_id;

select student.first_name , student.last_name , course.course_name, student_course.grade from student_course
join course on course.id = student_course.c_id
join student on student.id = student_course.s_id;

select student.first_name,  avg(student_course.grade) as AverageMarks from student_course
join student  on student.id = student_course.s_id 
group by student_course.s_id;
