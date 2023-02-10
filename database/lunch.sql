-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eatontime
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eatontime
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eatontime` DEFAULT CHARACTER SET utf8mb4;
USE `eatontime`;

-- -----------------------------------------------------
-- Table `eatontime`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`category`
(
    `id`            BIGINT      NOT NULL,
    `category_name` VARCHAR(45) NULL COMMENT '分类名称',
    `sort_number`   INT         NULL COMMENT '排序号',
    `create_time`   DATETIME    NULL COMMENT '创建时间',
    `update_time`   DATETIME    NULL COMMENT '修改时间',
    `del_flag`      TINYINT     NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '菜品分类';


-- -----------------------------------------------------
-- Table `eatontime`.`dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`dish`
(
    `id`          BIGINT        NOT NULL,
    `dish_name`   VARCHAR(100)  NULL COMMENT '菜品名称',
    `price`       DECIMAL       NULL COMMENT '价格',
    `category_id` BIGINT        NULL COMMENT '菜品分类：荤菜/素菜/...',
    `sale_count`  INT           NULL COMMENT '销量',
    `description` VARCHAR(100)  NULL COMMENT '菜品描述/备注',
    `status`      TINYINT       NULL COMMENT '上架状态',
    `sort_number` INT           NULL COMMENT '排序号',
    `picture_url` VARCHAR(1000) NULL COMMENT '图片地址',
    `create_time` DATETIME      NULL COMMENT '创建时间',
    `update_time` DATETIME      NULL COMMENT '修改时间',
    `del_flag`    TINYINT       NULL COMMENT '删除标志：0-未删除，1-已删除',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '菜品';


-- -----------------------------------------------------
-- Table `eatontime`.`combo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`combo`
(
    `id`          BIGINT        NOT NULL,
    `combo_name`  VARCHAR(100)  NULL COMMENT '套餐名',
    `price`       DECIMAL       NULL COMMENT '价格',
    `category_id` BIGINT        NULL COMMENT '分类id',
    `sale_count`  INT           NULL COMMENT '销量',
    `description` VARCHAR(100)  NULL COMMENT '描述/备注',
    `status`      TINYINT       NULL COMMENT '上架状态',
    `sort_number` TINYINT       NULL COMMENT '排序号',
    `picture_url` VARCHAR(1000) NULL COMMENT '图片地址',
    `create_time` DATETIME      NULL COMMENT '创建时间',
    `update_time` DATETIME      NULL COMMENT '修改时间',
    `del_flag`    TINYINT       NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '套餐';


-- -----------------------------------------------------
-- Table `eatontime`.`combo_dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`combo_dish`
(
    `id`          BIGINT   NOT NULL,
    `combo_id`    BIGINT   NULL COMMENT '套餐id',
    `dish_id`     BIGINT   NULL COMMENT '菜品id',
    `create_time` DATETIME NULL COMMENT '创建时间',
    `update_time` DATETIME NULL COMMENT '修改时间',
    `del_flag`    TINYINT  NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '套餐-菜品';


-- -----------------------------------------------------
-- Table `eatontime`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`user`
(
    `id`          BIGINT        NOT NULL,
    `username`    VARCHAR(100)  NULL COMMENT '用户名',
    `password`    VARCHAR(100)  NULL COMMENT '密码',
    `phone`       VARCHAR(11)   NULL COMMENT '手机号',
    `avatar`      VARCHAR(1000) NULL COMMENT '头像url',
    `status`      TINYINT       NULL COMMENT '用户状态：禁用/正常',
    `create_time` DATETIME      NULL COMMENT '创建时间',
    `update_time` DATETIME      NULL COMMENT '修改时间',
    `del_flag`    TINYINT       NULL COMMENT '删除标志',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE
)
    ENGINE = InnoDB
    COMMENT = '用户';


-- -----------------------------------------------------
-- Table `eatontime`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`cart`
(
    `id`          BIGINT        NOT NULL,
    `dish_name`   VARCHAR(100)  NULL COMMENT '菜名',
    `picture_url` VARCHAR(1000) NULL COMMENT '图片地址',
    `user_id`     BIGINT        NULL COMMENT '用户id',
    `dish_id`     BIGINT        NULL COMMENT '菜品id',
    `combo_id`    BIGINT        NULL COMMENT '套餐id',
    `dish_count`  INT           NULL COMMENT '数量',
    `price`       DECIMAL       NULL COMMENT '单价',
    `create_time` DATETIME      NULL COMMENT '创建时间',
    `update_time` DATETIME      NULL COMMENT '修改时间',
    `del_flag`    TINYINT       NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '购物车';


-- -----------------------------------------------------
-- Table `eatontime`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`order`
(
    `id`           BIGINT      NOT NULL,
    `order_number` VARCHAR(50) NULL COMMENT '订单号',
    `status`       INT         NULL COMMENT '订单状态：待付款/待配送/已派送/已完成/已取消',
    `user_id`      BIGINT      NULL COMMENT '下单用户',
    `address_id`   BIGINT      NULL COMMENT '地址/公司',
    `pay_type`     INT         NULL COMMENT '支付方式',
    `pay_amount`   DECIMAL     NULL COMMENT '支付金额',
    `create_time`  DATETIME    NULL COMMENT '创建时间',
    `update_time`  DATETIME    NULL COMMENT '修改时间',
    `del_flag`     TINYINT     NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '订单';


-- -----------------------------------------------------
-- Table `eatontime`.`order_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`order_item`
(
    `id`          BIGINT        NOT NULL,
    `order_id`    BIGINT        NULL COMMENT '订单id',
    `dish_name`   VARCHAR(100)  NULL COMMENT '菜名',
    `picture_url` VARCHAR(1000) NULL COMMENT '图片',
    `dish_id`     BIGINT        NULL COMMENT '菜品id',
    `combo_id`    BIGINT        NULL COMMENT '套餐id',
    `dish_count`  INT           NULL COMMENT '数量',
    `price`       DECIMAL       NULL COMMENT '单价',
    `create_time` DATETIME      NULL COMMENT '创建时间',
    `update_time` DATETIME      NULL COMMENT '修改时间',
    `del_flag`    TINYINT       NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '订单细节';


-- -----------------------------------------------------
-- Table `eatontime`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`address`
(
    `id`           BIGINT       NOT NULL,
    `company_name` VARCHAR(100) NULL COMMENT '公司名',
    `sort_number`  INT          NULL COMMENT '排序号',
    `create_time`  DATETIME     NULL COMMENT '创建时间',
    `update_time`  DATETIME     NULL COMMENT '修改时间',
    `del_flag`     TINYINT      NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '收获地址';


-- -----------------------------------------------------
-- Table `eatontime`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatontime`.`manager`
(
    `id`          BIGINT      NOT NULL,
    `username`    VARCHAR(45) NULL COMMENT '用户名',
    `password`    VARCHAR(45) NULL COMMENT '密码',
    `phone`       VARCHAR(45) NULL COMMENT '手机号',
    `status`      TINYINT     NULL COMMENT '状态：是否禁用',
    `create_time` DATETIME    NULL COMMENT '创建时间',
    `update_time` DATETIME    NULL COMMENT '修改时间',
    `del_flag`    TINYINT     NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = '经理';


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
