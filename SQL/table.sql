# Mysql版本8.24

# 创建数据库
create database ylan;
use ylan;

# 创建表结构
CREATE TABLE `t_user`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `phone_number`      varchar(256) DEFAULT NULL COMMENT '手机号',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_phone_number` (`phone_number`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

create table `t_teacher_schedule`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `teacher_id`    bigint(20) DEFAULT NULL COMMENT '教师ID',
    `teacher_name`  varchar(30) DEFAULT NULL COMMENT '教师姓名',
    `day`           datetime   DEFAULT NULL COMMENT '日期',
    `begin_time`    datetime   DEFAULT NULL COMMENT '开始时间',
    `end_time`      datetime   DEFAULT NULL COMMENT '结束时间',
    `day_type`      tinyint(1) DEFAULT NULL COMMENT '午别 0：上午 1：下午',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_teacherId_day_dayType` (`teacher_id`,`day`,`day_type`) USING BTREE
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;