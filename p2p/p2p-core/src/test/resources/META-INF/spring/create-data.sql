insert into user(id,id_user,login,password, firstName, lastName,active, registration) values (1, 1, 'MJ', 'password','MJ','Lee',TRUE,TRUE);
insert into role(id,id_role,name) values (1, 1, 'ADMIN');
insert into user_authorities(id,id_user, id_role) values (1, 1, 1);