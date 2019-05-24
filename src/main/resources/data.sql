insert into user (login, password, phone, role) values ('user1', 'user1', '0660757414', 'CUSTOMER'), ('manager1', 'manager1', '0660757414', 'MANAGER'),
                                                ('master1', 'master1', '0660757414', 'MASTER'), ('admin', 'admin', '0660757414', 'ADMIN');
insert into model (name, year) values ( 'GT-500', 2016 ), ('AR-15', 2018), ('S-450', 2016), ('GT-500', 2019);
insert into instruction (descr, model_id) values ( 'Do this', 1 ), ('Do that', 4), ('Do nothing', 2);
insert into instruction_allowed_regions values ( 1, 'CIS' ), (1, 'EUROPE'), (1, 'NA'), (2, 'EUROPE'), (2, 'NA'), (3, 'NA');
insert into user_master_allowed_regions values ( 3, 'CIS' ), (3, 'EUROPE');
insert into request (descr, date, customer_id) values ('Somth wrong', now(), 2), ('Nooooo', now(), 1), ('Well. okay', now(), 2);
insert into det_order (id, order_status, price) values (2, 'NOT_ACCEPTED', 400);
