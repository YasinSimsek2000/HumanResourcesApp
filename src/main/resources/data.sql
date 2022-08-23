INSERT INTO department(id, department_name) VALUES (1, 'Software Development Department');
INSERT INTO department(id, department_name) VALUES (2, 'Embedded Software Department');
INSERT INTO department(id, department_name) VALUES (3, 'Web Development Department');
INSERT INTO department(id, department_name) VALUES (4, 'Human Resource Department');


INSERT INTO employee(id, address, age, birth_date, email, marital_status, mobile, name, surname, title, department_id,
                     project_id, supervisor_id) VALUES (1, 'Ankara - Turkey', 21, '2000-11-30 10:00:00', 'simsekyasin2929@gmail.com',
                                                        'single', '05352317629', 'Yasin', 'Şimşek', 'Senior Software Engineer',
                                                        1, null, null);

INSERT INTO employee(id, address, age, birth_date, email, marital_status, mobile, name, surname, title, department_id,
                     project_id, supervisor_id) VALUES (2, 'Ankara - Turkey', 18, '2000-11-30 10:00:00', 'simsekyasin2900@gmail.com',
                                                        'single', '05352317629', 'Aleyna', 'Şimşek', 'Junior Software Engineer',
                                                        1, null, 1);

INSERT INTO employee(id, address, age, birth_date, email, marital_status, mobile, name, surname, title, department_id,
                     project_id, supervisor_id) VALUES (3, 'Ankara - Turkey', 41, '2000-11-30 10:00:00', 'agueros706@gmail.com',
                                                        'single', '05352317629', 'Nazan', 'Şimşek', 'Embedded Software Engineer',
                                                        2, null, null);

INSERT INTO employee(id, address, age, birth_date, email, marital_status, mobile, name, surname, title, department_id,
                     project_id, supervisor_id) VALUES (4, 'Ankara - Turkey', 48, '2000-11-30 10:00:00', 'agueros706@gmail.com',
                                                        'single', '05352317629', 'Hasan', 'Şimşek', 'Front-End Developer',
                                                        3, null, null);

INSERT INTO project(id, project_name, head_of_project_id) VALUES (1, 'Microservices', 1);
INSERT INTO project(id, project_name, head_of_project_id) VALUES (2, 'Vue.js', 4);

UPDATE employee SET project_id = 1 WHERE id = 1;
UPDATE employee SET project_id = 1 WHERE id = 2;
UPDATE employee SET project_id = 2 WHERE id = 4;