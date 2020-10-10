drop database makazadb;
create database makazadb;
use makazadb;

create table user_account (
	USER_NAME varchar(30) not null,
    STATUS varchar(3),
    PASSWORD varchar(255),
    PASSWORD_REMINDER_TOKEN varchar(100),
    PASSWORD_REMINDER_EXPIRE datetime,
    EMAIL_CONFIRMATION_TOKEN varchar(100),
    FIRST_NAME varchar(45),
    LAST_NAME varchar(45),
    EMAIL varchar(255),
    ADDRESS varchar(100),
    PHONE_NUMBER varchar(10),
    DEL_FLG char(1),
    primary key (USER_NAME)
);

create table roles(
	ID int(11) not null auto_increment,
    ROLE_NAME varchar(255),
    DEL_FLG char(1),
    primary key (ID)
);

create table user_role (
	USER_NAME varchar(30) not null,
    ROLE_ID int(11) not null,
    primary key (USER_NAME, ROLE_ID),
    foreign key (USER_NAME) references user_account (USER_NAME),
    foreign key (ROLE_ID) references roles (ID)
);
insert into roles (ID, ROLE_NAME, DEL_FLG) values (1, 'ADMIN', '0');
insert into roles (ID, ROLE_NAME, DEL_FLG) values (2, 'MEMBER', '0');

insert into user_account(USER_NAME, STATUS, PASSWORD, PASSWORD_REMINDER_TOKEN, PASSWORD_REMINDER_EXPIRE, EMAIL_CONFIRMATION_TOKEN, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, PHONE_NUMBER, DEL_FLG) 
values ('minhlv1509', '1', '$2a$10$CDlIjXA4bRMrAEIzgTf0ye3Fd9IEk62LXT7iSa60VJLxdioyokiSq', 'password_token', '2020-10-10 00:00:00', 'email_token', 'Minh', 'Lê', 'minhlv1509@gmail.com', 'Ha Noi', '0363503879', '0');

insert into user_account(USER_NAME, STATUS, PASSWORD, PASSWORD_REMINDER_TOKEN, PASSWORD_REMINDER_EXPIRE, EMAIL_CONFIRMATION_TOKEN, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, PHONE_NUMBER, DEL_FLG) 
values ('lvm', '1', '$2a$10$3yRRa8/ySaUPWSCW62bqWeVetyTRpJ2GOONGcogRKb3eDZbmphG9C', 'password_token', '2020-10-10 00:00:00', 'email_token', 'Minh', 'Lê', 'minhlv1509@gmail.com', 'Ha Noi', '0363503879', '0');

insert into user_role (USER_NAME, ROLE_ID) values ('minhlv1509', 1);
insert into user_role (USER_NAME, ROLE_ID) values ('lvm', 2);