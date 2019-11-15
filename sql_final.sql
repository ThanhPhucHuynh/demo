CREATE DATABASE book_db CHARACTER SET utf8;
use book_db;
desc books;
create table category (
    id_category varchar(8) primary key,
    name_category varchar(40)
);
create table readers (
    id_readers varchar(8) primary key,
    name_readers varchar(50),
    address_readers varchar(200),
    phone_readers char(10)
);
create table admin (
    id_admin varchar(8) primary key,
    account varchar(20),
    password_hash varchar(64),
    address_admin varchar(200),
    phone_admin char(10)
);
create table books (
    id_book varchar(8) primary key,
    name_book varchar(40),
    author_book varchar(40),
    id_category varchar(8),
    numbers_book int,
    price_book int,
    constraint foreign key (id_category)
        references category (id_category)
);




delimiter $$
create procedure sp_addcategory(idcategory varchar(8),
															namecategory varchar(40))
begin
	insert into category values(idcategory,namecategory);
end$$
delimiter ;
delimiter $$
create procedure sp_addbook(		idbook varchar(8),
															namebook varchar(40),
															author varchar(40),
															idcategory varchar(8),
															numbers int,
															price int)
begin
	insert into books values(idbook,namebook,author,idcategory,numbers,price);
end$$
delimiter ;
delimiter $$
create procedure sp_readers(		idreaders varchar(8),
															namereaders varchar(50),
															address varchar(200),
															phone char(10))
begin
	insert into readers values(idreaders,namereaders,address,phone	);
end$$
delimiter ;
delimiter $$
create procedure sp_addborrow(	idbook varchar(8),
															idreaders varchar(8),
															date_begin date,
															date_return date)
begin
	DECLARE date_end date; 
	set date_end = ADDDATE(date_begin,7);
	insert into borrow values(idbook,idreaders,date_begin,date_end,null);
end$$
delimiter ;

delimiter $$
create procedure sp_updatebook(		idbook varchar(8),
															numbers int)
begin
	update  books  set numbers_book = numbers where id_book = idbook;
end$$
delimiter ;
delimiter $$
create procedure sp_delbook(idbook varchar(8)
															)
begin
	DELETE FROM books
		WHERE id_book =idbook;
end$$
delimiter ;
delimiter $$
create procedure sp_updatereaders(		id varchar(8),
															name_re varchar(50),
															address varchar(200),
															phone char(10))
begin
	update  readers  set  name_readers= name_re,address_readers=address ,phone_readers=phone
where id_readers = id;
end$$
delimiter ;
delimiter $$
create procedure sp_delreaders(id varchar(8)
															)
begin
	DELETE FROM readers
		WHERE id_readers =id;
end$$
delimiter ;

delimiter $$
create function getAdmin ( account varchar(20) )
returns varchar(64)  
begin
	declare pass varchar(64) default 'xxx';
	select  password_hash into pass
	from admin
	where admin.account = account;
	return pass;
end$$
delimiter ;
delimiter $$
create function getName ( id varchar(8) )
returns varchar(64)  
begin
	declare pass varchar(64) default 'xxx';
	select  name_readers into pass
	from readers
	where readers.id_readers = id;
	return pass;
end$$
delimiter ;
delimiter $$
create function getTL ( id varchar(20) )
returns varchar(40)  
begin
	declare TLname varchar(40) default 'xxx';
	select name_category into TLname 
	from category
	where
    category.id_category = id;
	return TLname;
end$$
delimiter ;

delimiter $$
create function getSL ( id varchar(8) )
returns int
begin
	declare SL int default -1;
	select  numbers_book as sl into SL  
	from books
	where
    books.id_book = id;
	return SL;
end$$
delimiter ;
DROP  FUNCTION IF EXISTS getSL;

select getSL("1313");

select getTL('TT');

call sp_addcategory("TT","Trinh Tham");
call sp_addcategory("TN","Truyen Ngan");
call sp_addcategory("KN","Ky Nang");
call sp_addcategory("NN","Nuoc Ngoai");
call sp_addcategory("KH","Khac");

call sp_readers('B17','HUynh thanh Phuc','Dong thap','0347766101');

call sp_delbook("454");
call sp_updatebook("123",4);
call sp_addbook("123","dung lua chon an nhan khi con tre","thanh phuc","KN",2,40000);
call sp_addbook("113","tuoi tre dang gia bao nhieu","thanh phuc","KN",2,50000);
call sp_addbook("124","The liitle Prince","thanh phuc","TN",2,80000);

insert into admin value("9a3","B1706515","123456789","Dong Thap","0347766101");



select 
    *
from
    category;
select 
    *
from
    books;
select 
    *
from
    readers;
select id_book,name_book,author_book,id_category,numbers_book,price_book from books