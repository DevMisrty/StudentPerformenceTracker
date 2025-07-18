use studentmanagement;

insert into student_courses (s_id,c_id) values (7,104), (8,101);

update student_courses set grade = 100 where s_id =7 and c_id=104;