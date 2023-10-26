drop database if exists qma;
create database if not exists qma;

create table user
(
    id       int auto_increment
        primary key,
    name     varchar(50) null,
    username varchar(50) null,
    password varchar(50) null
);

INSERT INTO qma.user (name, username, password)
VALUES ('旺旺旺', 'li', '123');
INSERT INTO qma.user (name, username, password)
VALUES ('奥特曼', 'ao', '123');
INSERT INTO qma.user (name, username, password)
VALUES ('管理员', 'admin', '123');

create table hospital
(
    id     int auto_increment
        primary key,
    doctor varchar(150) null,
    dept   varchar(150) null,
    time   varchar(150) null,
    num    int          null
);

INSERT INTO qma.hospital (doctor, dept, time, num)
VALUES ('张医生', '内科', '08:30-11:30', 0);
INSERT INTO qma.hospital (doctor, dept, time, num)
VALUES ('李医生', '外科', '08:30-11:30', 39);
INSERT INTO qma.hospital (doctor, dept, time, num)
VALUES ('王医生', '儿科', '14:30-17:30', 18);
INSERT INTO qma.hospital (doctor, dept, time, num)
VALUES ('常医生', '儿科', '08:30-11:30', 18);
INSERT INTO qma.hospital (doctor, dept, time, num)
VALUES ('白医生', '儿科', '14:30-17:30', 18);
INSERT INTO qma.hospital (doctor, dept, time, num)
VALUES ('李四', '儿科', '08:30-11:30', 18);

create table order_num
(
    id     bigint      not null
        primary key,
    dept   varchar(50) null,
    time   varchar(50) null,
    doctor varchar(50) null,
    money  decimal     null,
    user   varchar(50) null
);

INSERT INTO qma.order_num (id, dept, time, doctor, money, user)
VALUES (1717450973428604929, '外科', '08:30-11:30', '李医生', 50, '李静旺');
INSERT INTO qma.order_num (id, dept, time, doctor, money, user)
VALUES (1717451003057168385, '外科', '08:30-11:30', '李医生', 50, '李静旺');
INSERT INTO qma.order_num (id, dept, time, doctor, money, user)
VALUES (1717451014704750594, '外科', '08:30-11:30', '李医生', 50, '李静旺');
INSERT INTO qma.order_num (id, dept, time, doctor, money, user)
VALUES (1717451023475040258, '儿科', '14:30-17:30', '王医生', 50, '李静旺');
INSERT INTO qma.order_num (id, dept, time, doctor, money, user)
VALUES (1717454176920604673, '外科', '08:30-11:30', '李医生', 50, '管理员');
INSERT INTO qma.order_num (id, dept, time, doctor, money, user)
VALUES (1717463831415689217, '外科', '08:30-11:30', '李医生', 50, '管理员');
INSERT INTO qma.order_num (id, dept, time, doctor, money, user)
VALUES (1717463861350436866, '儿科', '08:30-11:30', '李四', 50, '管理员');
