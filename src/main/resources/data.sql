insert into user (login, password, role) values ('user1', 'user1', 'CUSTOMER'), ('manager1', 'manager1', 'MANAGER'),
                                                ('master1', 'master1', 'MASTER');
insert into request (descr, date, customer_id) values ('Somth wrong', now(), 1), ('Nooooo', now(), 1);