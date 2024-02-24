# Mysql版本8.24

# 创建数据库
create database lejingling;
use lejingling;

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