insert into department(id,department_name) values (1,'Software Development Department');
insert into department(id,department_name) values (2,'Embedded Software Department');
insert into department(id,department_name) values (3,'Web Development Department');
insert into department(id,department_name) values (4,'Human Resource Department');

insert into employee(id, address, age, birth_date, email,
                     marital_status, mobile, name, surname, title,
                     department_id, supervisor_id)
                     values (1, 'Ankara - Turkey', 21, '2000-11-30 10:00:00',
                             'simsekyasin2900@gmail.com', 'single', '05352317629',
                             'Yasin', 'Şimşek', 'Senior Software Engineer', 1, null);

insert into employee(id, address, age, birth_date, email,
                     marital_status, mobile, name, surname, title,
                     department_id, supervisor_id)
                    values (2, 'Ankara - Turkey', 17, '2005-02-03 20:00:00',
                            'simsekaleyna2900@gmail.com', 'single', '05352317629',
                            'Aleyna', 'Şimşek', 'Intern', 2, 1);
insert into employee(id, address, age, birth_date, email,
                     marital_status, mobile, name, surname, title,
                     department_id, supervisor_id)
                    values (3, 'Ankara - Turkey', 45, '1973-11-17 10:00:00',
                            'simsekhasan2900@gmail.com', 'married', '05352317629',
                            'Hasan', 'Şimşek', 'Senior Software Engineer', 3, null);

