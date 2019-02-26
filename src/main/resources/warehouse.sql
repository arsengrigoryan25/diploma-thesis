-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2018 at 11:48 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `warehouse`
--
DROP DATABASE IF EXISTS warehouse;
CREATE DATABASE warehouse;
USE warehouse;

-- --------------------------------------------------------
--
-- Table structure for table `users`
--
CREATE TABLE `users`
(
  `id`        int(11)      NOT NULL,
  `name`      varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `status`    varchar(255) NOT NULL,
  `active`    bool  NOT NULL,
  `username`  varchar(255) NOT NULL,
  `password`  varchar(255) NOT NULL

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
--
-- Dumping data for table `users`
--
INSERT INTO `users` (`id`, `active`, `status`, `last_name`, `name`, `username`, `password`)
VALUES (1, true, '1', 'arsen', 'grigoryan', 'ars', 'ars'),
       (2, true, '0', 'arman', 'grigoryan', 'arm', 'arm');

-- ----------------------------------------------------------------------------------------------------------------
--
-- Table structure for table `role`
--
CREATE TABLE `role`
(
  `id`   int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
--
-- Dumping data for table `role`
--
INSERT INTO `role` (`id`, `role`)
VALUES (1, 'ADMIN'),
       (2, 'USER');

-- -------------------------------------------------------------------------------------------------------------
--
-- Table structure for table `user_role`
--
CREATE TABLE `user_role`
(
  `id`      int     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
--
-- Dumping data for table `user_role`
--
INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES (1, 1),
       (2, 2);

-- ----------------------------------------------------------------------------------------------------------------
--
-- Table structure for table `products`
--
CREATE TABLE `products`
(
  `id`                 int(8) UNSIGNED NOT NULL,
  `name`               varchar(255)    NOT NULL,
  `description`        varchar(255)    NOT NULL,
  `count_in_warehouse` varchar(255)    NOT NULL,
  `purchase_price`     varchar(255)    NOT NULL,
  `sale_price`         varchar(255)    NOT NULL,
  `expiration_date`    varchar(255),
  `product_code`       varchar(255)    NOT NULL,
  `barcode`            varchar(255)    NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
--
-- Dumping data for table `products`
--
INSERT INTO `products` (`id`, `name`, `description`, `count_in_warehouse`, `purchase_price`, `sale_price`, `expiration_date`, `product_code`,
                        `barcode`)
VALUES (1, 'lucki', 'haykakan lucki', '1', '100', '110', '2018-02-02', '12345678', '87654321'),
       (2, 'grich', 'sev grich', '1', '120', '130', '2018-02-02', '23456789', '98765432');

-- ----------------------------------------------------------------------------------------------------------------

/* Products table
ID - ID
name - Անուն
description - նկարագրությունը
code - կոդը
purchase_data - գնելու ամսաթիվը
sale _data - վաճառքի ամսաթիվը
count_In_warehouse - Պահեստում առկա ապրանքի քանակը
expiration_date - պիտանելության ժամկետ
product_code - ապրանքի կոդը
barcode - շտրիխ կոդ
purchase_price - գնման գին
sale_price - վաճառքի գին
*/

/* Գորշողությունների table
ID - ID

 */


/*
ID - ID
name - Անուն
description - նկարագրությունը
code - կոդը
purchase_data - գնելու ամսաթիվը
sale _data - վաճառքի ամսաթիվը
count_In_warehouse - Պահեստում առկա
purchase_price - գնման գին
sale_price - վաճառքի գին
expiration_date - պիտանելության ժամկետ
product_code - ապրանքի կոդը
barcode - շտրիխ կոդ
*/