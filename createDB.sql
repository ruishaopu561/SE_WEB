create database web;
use web;
create table books(name	varchar(30), writer	varchar(30), price int(5), ISBN	varchar(20), inventory int(4));
insert into books value('Harry Potter','J. K. Rowling', 3000,	'‎978-3-16-148410-0',5);
insert into books value('King of the Ring','John Ronald Reuel Tolkien',5000,'178-3-16-148410-0',9);
insert into books value('The Three-Body Problem', 'Liu Cixin', 4000,'‎278-3-16-148410-0',7);