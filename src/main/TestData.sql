use studentmanagement;

insert into student_courses (s_id,c_id) values (7,104), (8,101);

update student_courses set grade = 100 where s_id =7 and c_id=104;

select  student.id, student.first_name, student.last_name, student_course.c_id , student_course.grade 
from student_course 
join student 
on student.id = student_course.s_id;
