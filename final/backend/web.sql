use web;

create table if not exists books (
    id int(32) not null auto_increment primary key,
    name varchar(32),
    writer varchar(32),
    ISBN varchar(32),
    price int(32),
    inventory int(32)
)engine=InnoDB default charset=utf8;

create table if not exists users (
    id int(32) not null auto_increment primary key,
    firstname varchar(32),
    lastname varchar(32),
    email varchar(32),
    password varchar(32),
    active boolean
)engine=InnoDB default charset=utf8;

create table if not exists orders (
    id int(32) not null auto_increment primary key,
    userId varchar(32),
    value float,
    paied boolean,
    time varchar(32)
)engine=InnoDB default charset=utf8;

create table if not exists items (
    id int(32) not null auto_increment primary key,
    orderId int(32),
    bookId int(32),
    amount int(32),
    value float
)engine=InnoDB default charset=utf8;
