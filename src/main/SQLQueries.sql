use studentmanagement;

create table student (
	id int primary key,
    first_name varchar(50),
    last_name varchar(50)
);
INSERT INTO student (id, first_name, last_name) VALUES
(1, 'Alice', 'Johnson'),
(2, 'Bob', 'Smith'),
(3, 'Charlie', 'Williams'),
(4, 'Diana', 'Brown'),
(5, 'Ethan', 'Davis'),
(6, 'Fiona', 'Clark'),
(7, 'George', 'Lewis'),
(8, 'Hannah', 'Young'),
(9, 'Ian', 'Hall'),
(10, 'Julia', 'Allen');


create table course (
	id int primary key,
    course_name varchar(25)
);
alter table course 
change course_name course_name varchar(100);

INSERT INTO course (id, course_name) VALUES
(101, 'Mathematics'),
(102, 'Physics'),
(103, 'Chemistry'),
(104, 'Biology'),
(105, 'Computer Science'),
(106, 'English'),
(107, 'History'),
(108, 'Geography'),
(109, 'Economics'),
(110, 'Art');


create table student_course(
	s_id int,
    c_id int,
    grade int,
    foreign key (s_id) references student(id) ON Delete Cascade,
    foreign key (c_id) references course(id),
    primary key (s_id,c_id)
);

alter table student_course 
change grade grade enum('A','B','C','D','E');

INSERT INTO student_course (s_id, c_id, grade) VALUES
(1, 101, 92),
(1, 102, 85),
(1, 103, 78),

(2, 101, 88),
(2, 104, 73),
(2, 105, 91),

(3, 106, 95),
(3, 107, 82),
(3, 108, 67),

(4, 101, 58),
(4, 109, 69),
(4, 103, 72),

(5, 110, 86),
(5, 102, 63),
(5, 106, 91),

(6, 107, 77),
(6, 101, 80),

(7, 104, 68),
(7, 105, 94),

(8, 108, 88),
(8, 109, 79),

(9, 110, 92),
(9, 101, 65),

(10, 102, 74),
(10, 103, 83);

