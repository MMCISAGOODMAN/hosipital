create table user
(
   id                   varchar(20)      comment '主键' not null,
   username             varchar(20)      comment '用户名',
   password             varchar(40)      comment '密码',
   sex                  varchar(2)       comment '性别',
   id_cart              varchar(20)      comment '身份证',
   telphone             varchar(20)      comment '电话号码',
   type                 varchar(2)       comment '类型 1-医生 2-工作人员 3-普通人',
   primary key (id)
);
alter table user comment '用户';

create table schedule
(
   id                   varchar(20)      comment '主键' not null,
   doctor_id            varchar(20)      comment '医生ID',
   schedule_date        date             comment '排班日期',
   total_quota          int              comment '每天预约总额度',
   current_quota        int              comment '当前已预约',
   current_number       int              comment '当前号数',
   primary key (id)
);
alter table schedule comment '排班';


create table book_detail
(
   id                   varchar(20)      comment '主键' not null,
   user_id              varchar(20)      comment '用户ID',
   schedule_id          varchar(20)      comment '排班ID',
   schedule_number      int              comment '预约号',
   status               varchar(2)       comment '状态 1-待就诊 2-已就诊',
   result               varchar(2000)    comment '诊断结果',
   primary key (id)
);
alter table book_detail comment '预约记录';

