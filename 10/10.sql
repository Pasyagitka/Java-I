use master
GO
create database Java10
GO
use Java10
GO
create table Records(
	id int identity(1,1) primary key,
	name nvarchar(20) not null,
	phonenumber decimal null,
	email nvarchar(20) null
)
GO
create table Users(
	id int identity(1,1) primary key,
	login nvarchar(20) not null,
	password nvarchar(20) not null,
	role nvarchar(10) not null
)
GO

insert into Records(name, phonenumber) values ('Сестра', 375445634339)
insert into Records(name, phonenumber,email) values ('Мама', 375293765222, 'mama@mail.ru')
GO

select * from Records
select * from Users
GO