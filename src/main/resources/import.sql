INSERT INTO user(name,surname,email,password,created_at,picture) VALUES('Emmanuel',' Cobian Zamora','emmanuel@gmail.com','12345','2020-07-19','');
INSERT INTO user(name,surname,email,password,created_at,picture) VALUES('Memo',' Cobian Zamora','memorama@gmail.com','9898','2020-07-19','');

INSERT INTO resume(user_id) VALUES(1);
INSERT INTO resume(user_id) VALUES(2);

INSERT INTO projects(name,description,started_date,end_date,user_id) VALUES("Task Manager","Web page to control the projects progress adding tasks and mark them as finished and adding new projects.",'2019-08-19','2019-07-12',1);
INSERT INTO projects(name,description,started_date,end_date,user_id) VALUES("QR Poliza","Generate a QR code with the data of a poliza to scan it and show all the data in a we page",'2019-06-10','2019-08-05',1);

INSERT INTO tools(name,user_id) VALUES("PHP",1);
INSERT INTO tools(name,user_id) VALUES("HTML5",1);
INSERT INTO tools(name,user_id) VALUES("JavaScript",1);
INSERT INTO tools(name,user_id) VALUES("Java",1);
INSERT INTO tools(name,user_id) VALUES("Eclipse",1);
INSERT INTO tools(name,user_id) VALUES("NodeJS",1);

INSERT INTO leadership(description,date,user_id) VALUES("Volunteer int collection of toys for children in need by IEEE.","2018-04-25",1);
INSERT INTO leadership(description,date,user_id) VALUES("Volunteer as scratch instructor in the science and technology week of the Instituto Tecnológico De Ciudad Guzman.","2018-03-20",1);

INSERT INTO projects_tools(projects_id,tools_id) VALUES(1,1);
INSERT INTO projects_tools(projects_id,tools_id) VALUES(1,2);
INSERT INTO projects_tools(projects_id,tools_id) VALUES(1,3);
INSERT INTO projects_tools(projects_id,tools_id) VALUES(2,4);
INSERT INTO projects_tools(projects_id,tools_id) VALUES(2,5);
INSERT INTO projects_tools(projects_id,tools_id) VALUES(2,1);

INSERT INTO resume_projects(resume_id,projects_id) VALUES(1,1);
INSERT INTO resume_projects(resume_id,projects_id) VALUES(1,2);
INSERT INTO resume_projects(resume_id,projects_id) VALUES(2,1);