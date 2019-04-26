insert into user (login, password, role) values ('user1', 'user1', 'CUSTOMER'), ('manager1', 'manager1', 'MANAGER'),
                                                ('master1', 'master1', 'MASTER');
insert into model (name, year) values ( 'GT-500', 2016 ), ('AR-15', 2018), ('S-450', 2016), ('GT-500', 2019);
insert into instruction (descr, model_id) values ( 'Do this', 1 ), ('Do that', 4), ('Do nothing', 2);
insert into instruction_allowed_regions values ( 1, 'CIS' ), (1, 'EUROPE'), (1, 'NA'), (2, 'EUROPE'), (2, 'NA'), (3, 'EUROPE');
insert into user_master_allowed_regions values ( 3, 'CIS' ), (3, 'EUROPE');
insert into request (descr, date, customer_id) values ('Somth wrong', now(), 1), ('Nooooo', now(), 1);
