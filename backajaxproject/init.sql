create database lecture;
use lecture;

drop table list;

create table list(
 num int primary key auto_increment,
 subject varchar(100) not null,
 content varchar(2000),
 date date,
 readcount int default 0
 );

insert into list values(1,'test1','test1','2023-03-02',23);
insert into list values(2,'test2','test2','2023-03-02',35);
insert into list values(3,'test3','test3','2023-03-02',46);
insert into list values(4,'test4','test4','2023-03-02',27);
insert into list values(5,'test5','test5','2023-03-02',14);
insert into list values(6,'test6','test6','2023-03-02',51);
insert into list values(7,'test7','test7','2023-03-02',35);
insert into list values(8,'test8','test8','2023-03-02',29);

