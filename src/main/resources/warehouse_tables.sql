-- -- phpMyAdmin SQL Dump
-- -- version 4.7.7
-- -- https://www.phpmyadmin.net/
-- --
-- -- Host: 127.0.0.1
-- -- Generation Time: Jun 10, 2018 at 11:48 PM
-- -- Server version: 10.1.30-MariaDB
-- -- PHP Version: 7.2.2
--
-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- SET AUTOCOMMIT = 0;
-- START TRANSACTION;
-- SET time_zone = "+00:00";
--
-- --
-- -- Database: `warehouse`
-- --
-- DROP DATABASE IF EXISTS warehouse;
-- CREATE DATABASE warehouse;
-- USE warehouse;
--
-- -- --------------------------------------------------------
-- --
-- -- Table structure for table `users`
-- --
-- CREATE TABLE `users`
-- (
--   `id`        int(11)      NOT NULL,
--   `name`      varchar(255) NOT NULL,
--   `last_name` varchar(255) NOT NULL,
--   `status`    varchar(255) NOT NULL,
--   `active`    bool         NOT NULL,
--   `username`  varchar(255) NOT NULL,
--   `password`  varchar(255) NOT NULL
--
-- )
--   ENGINE = InnoDB
--   DEFAULT CHARSET = utf8;
-- -- ----------------------------------------------------------------------------------------------------------------
-- --
-- -- Table structure for table `role`
-- --
-- CREATE TABLE `role`
-- (
--   `id`   int(11)      NOT NULL,
--   `role` varchar(255) NOT NULL
-- )
--   ENGINE = InnoDB
--   DEFAULT CHARSET = latin1;
-- -- -------------------------------------------------------------------------------------------------------------
-- --
-- -- Table structure for table `user_role`
-- --
-- CREATE TABLE `user_role`
-- (
--   `id`      int     NOT NULL AUTO_INCREMENT PRIMARY KEY,
--   `user_id` int(11) NOT NULL,
--   `role_id` int(11) NOT NULL
-- )
--   ENGINE = InnoDB
--   DEFAULT CHARSET = latin1;
-- -- ----------------------------------------------------------------------------------------------------------------
-- --
-- -- Table structure for table `products`
-- --
-- CREATE TABLE `products`
-- (
--   `id`                 int(8) UNSIGNED NOT NULL,
--   `name`               varchar(255)    NOT NULL,
--   `name`               varchar(255)    NOT NULL,
--   `description`        varchar(255),
--   `count_in_warehouse` varchar(255)    NOT NULL,
--   `purchase_price`     varchar(255)    NOT NULL,
--   `sale_price`         varchar(255)    NOT NULL,
--   `expiration_date`    varchar(255),
--   `product_code`       varchar(255)    NOT NULL,
--   `barcode`            varchar(255)    NOT NULL
-- )
--   ENGINE = InnoDB MyISAM
--   DEFAULT CHARSET = utf8;
-- -- ----------------------------------------------------------------------------------------------------------------

-- auto-generated definition
create table products_in_shop
(
  id              int          not null
    primary key,
  barcode         varchar(255) null,
  count           varchar(255) null,
  expiration_date varchar(255) null,
  name            varchar(255) null,
  product_code    varchar(255) null,
  sale_price      varchar(255) null,
  type            varchar(255) null
)
  engine = MyISAM;

-- auto-generated definition
create table products_in_warehouse
(
  id              int          not null
    primary key,
  barcode         varchar(255) null,
  count           varchar(255) null,
  description     varchar(255) null,
  expiration_date varchar(255) null,
  name            varchar(255) null,
  product_code    varchar(255) null,
  purchase_price  varchar(255) null,
  sale_price      varchar(255) null,
  type            varchar(255) null
)
  engine = MyISAM;

-- auto-generated definition
create table role
(
  id   int          not null
    primary key,
  role varchar(255) null
)
  engine = MyISAM;

-- auto-generated definition
create table user_role
(
  user_id bigint not null,
  role_id int    not null,
  primary key (user_id, role_id)
)
  engine = MyISAM;
create index FKa68196081fvovjhkek5m97n3y
  on user_role (role_id);

-- auto-generated definition
create table users
(
  id        bigint       not null
    primary key,
  active    bit          not null,
  last_name varchar(255) null,
  name      varchar(255) null,
  password  varchar(255) null,
  status    varchar(255) null,
  username  varchar(255) null
)
  engine = MyISAM;




