drop table if exists  user;
create table user(user_id int auto_increment primary key,
user_name varchar(64) ,
user_password varchar(64)
);