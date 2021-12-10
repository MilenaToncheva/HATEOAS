INSERT INTO STUDENTS (ID,AGE,NAME)
values
('1',33,'Pesho'),
('2',55,'Mara'),
('3',15,'Nik');

INSERT INTO COURSES (ID,ENABLED,NAME,PRICE)
values
('1',0,'JAVA',450),
('2',0,'SPRING',450),
('3',0,'C#',450);

INSERT INTO ORDERS(ID,COURSE_ID, STUDENT_ID)
values
('1',1,3),
('2',2,1),
('3',1,2),
('4',3,1);