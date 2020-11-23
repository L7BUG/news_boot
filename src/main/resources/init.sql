create database news char set utf8;
use news;
create table Role
(
    id     int auto_increment not null comment '角色ID'
        primary key,
    name   varchar(20)        null comment '角色名称',
    remark text               null comment '角色备注',
    constraint unique (name)
) char set utf8;
insert into Role (name, remark)
values ('admin', '超级管理员就是这个系统的上帝'),
       ('author', '打工仔作者');

create table User
(
    id           int auto_increment comment '用户ID'
        primary key,
    username     varchar(20)                        not null comment '登陆账号',
    password     varchar(20)                        not null comment '登陆密码',
    roleId       int                                null comment '角色ID',
    tel          varchar(50)                        null comment '联系电话',
    registerTime datetime default CURRENT_TIMESTAMP null comment '注册时间',
    status       int      default 1                 null comment '注册状态 1:未启用 2: 启用 3: 被禁用',
    constraint
        unique (username),
    constraint
        foreign key (roleId) references Role (id)
) char set utf8;
insert into User (username, password, roleId)
values ('admin', '123456', 1);

create table if not exists Category
(
    id   int primary key auto_increment comment '类别ID',
    name varchar(20) comment '类别名称'
) char set utf8;
insert into Category(name)
values ('国内'),
       ('国际'),
       ('军事'),
       ('财经'),
       ('体育'),
       ('娱乐');
create table if not exists New
(
    id            int primary key auto_increment comment '新闻id',
    title         varchar(60) not null comment '信息标题',
    titlePicUrl   text comment '标题图(路径)',
    content       text        not null comment '信息内容',
    categoryId    int         not null comment '信息类别ID',
    userId        int         not null comment '发布用户ID',
    publishTime   datetime default current_timestamp comment '发布时间 默认为 当前时间',
    clicks        int comment '浏览次数',
    publishStatus char(1) comment '状态 1: 发布 2: 删除',
    constraint foreign key (userId) references User (id),
    constraint foreign key (categoryId) references Category (id)
) char set utf8;
create table if not exists comment
(
    id      int primary key auto_increment comment '评论id',
    newId   int  not null comment '新闻id',
    content text not null comment '评论内容',
    constraint foreign key (newId) references New (id)
) char set utf8;
insert into Role(id, name, remark) value ();