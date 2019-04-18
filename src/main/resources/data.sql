insert into course(id, name) values (1, 'course1');
insert into course(id, name) values (2, 'course2');
insert into course(id, name) values (3, 'course3');

insert into passport(id, number) values(1, 'p1');
insert into passport(id, number) values(2, 'p2');
insert into passport(id, number) values(3, 'p3');

insert into student(id, name, passport_id) values(1, 's1', 1);
insert into student(id, name, passport_id) values(2, 's2', 2);
insert into student(id, name, passport_id) values(3, 's3', 3);

insert into review(id, rating, description, course_id) values(1, '5', 'd1', 1);
insert into review(id, rating, description, course_id) values(2, '5', 'd2', 1);
insert into review(id, rating, description, course_id) values(3, '5', 'd3', 3);

insert into student_course(student_id, course_id) values (1,1);
insert into student_course(student_id, course_id) values (2,1);
insert into student_course(student_id, course_id) values (3,1);
insert into student_course(student_id, course_id) values (1,3);