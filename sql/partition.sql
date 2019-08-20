-- 查看当前数据库是否启用了分区功能
show variables like '%partition%';

show plugins ;

# 当表中有主键或者索引索引的时候，分区列必须包含主键或者唯一索引
# 如果表中没有指定主键、唯一索引时，可以指定任何一个列为分区列
create table partdemo (
    id int primary key auto_increment comment '主键',
    username varchar(64) comment '用户名',
    pwd varchar(255) comment '密码'
)
partition by range (id) (
    partition p0 values less than (10),
    partition p1 values less than (20),
    partition p2 values less than (MAXVALUE)
    );

insert into partdemo(username, pwd)
VALUES ('a', '123456'),('b', '123456'),
       ('c', '123456'),('d', '123456'),
       ('e', '123456'),('f', '123456'),
       ('g', '123456'),('h', '123456'),
       ('i', '123456'),('j', '123456'),
       ('k', '123456'),('l', '123456');

select * from information_schema.PARTITIONS
where TABLE_SCHEMA = database() and TABLE_NAME = 'partdemo';

alter table partdemo add partition (
    partition p2 values less than (30)
    );

select * from partdemo where id > 6;

explain PARTITIONS select * from partdemo where id >6 ;
explain PARTITIONS select * from partdemo where id >6 and id < 13;

/**
  range list hash key分区，分区的条件必须是整型
 */
# range分区
create table listpart(
#     id int primary key auto_increment comment 'id',    -- 会报错
    id int comment 'id',
    username varchar(64) not null comment 'user name',
    gender tinyint(2) not null default 0 comment 'gender'
)engine = InnoDb
partition by list(gender) (
    partition p0 values in (0),
    partition p1 values in (1),
    partition p2 values in (2)
    );


insert into listpart(id, username, gender)
VALUES (1, 'wjh', 1),(2, 'xcf', 2),
       (3, 'lsx',2),(4,'cq',0);

insert into listpart (id, username, gender)
values (5,'sb', 0);
/**
  分区后  根据分区列来排序的，暂时不知道是不是默认设置的
 */
select * from listpart;

explain select * from listpart where gender > 0;