# ====================================================================================================================================================
#   CREATE DATABASE
# ====================================================================================================================================================
DROP DATABASE warehouse;
CREATE DATABASE warehouse CHARACTER SET utf8 COLLATE utf8_general_ci;
USE warehouse;

# ====================================================================================================================================================
#   CREATE TABLE
# ====================================================================================================================================================
#   DROP TABLE users;
#   DROP TABLE products;
#   DROP TABLE product_type;
#   DROP TABLE info;
#   DROP TABLE hibernate_sequence;

-- auto-generated definition
create table users
(
    id        bigint          not null
        primary key AUTO_INCREMENT,
    active    bit          not null,
    last_name varchar(255) null,
    name      varchar(255) null,
    password  varchar(255) null,
    role      varchar(255) null,
    username  varchar(255) null,
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (username),
    constraint UK_r53o2ojjw4fikudfnsuuga336
        unique (password)
)
    engine = MyISAM;

-- auto-generated definition
create table products
(
    id                 int          not null
        primary key AUTO_INCREMENT,
    bar_code           varchar(255) null,
    count_in_shop      int          null,
    count_in_warehouse int          null,
    description        varchar(255) null,
    name               varchar(255) null,
    product_code       varchar(255) null,
    product_type_id    varchar(255) null,
    purchase_price     varchar(255) null,
    sale_price         varchar(255) null,
    constraint UK_ks7bl2r407pphq72vxpufxqn
        unique (bar_code)
)
    engine = MyISAM;

-- auto-generated definition
create table product_type
(
    id   int          not null
        primary key AUTO_INCREMENT,
    name varchar(255) null,
    constraint UK_bnu2aqss00w6he2vs4bmmy609
        unique (name)
)
    engine = MyISAM;

-- auto-generated definition
create table info
(
    id          int          not null
        primary key AUTO_INCREMENT,
    change_date datetime     null,
    info        varchar(255) null
)
    engine = MyISAM;

-- auto-generated definition
create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;


# ====================================================================================================================================================
#   CLEAN DATA in TABLE
# ====================================================================================================================================================
truncate table users;
truncate table products;
truncate table product_type;
truncate table info;


# ====================================================================================================================================================
#   INSERT
        # ====================================================================================================================================================
INSERT INTO users (last_name, name, role, active, username, password)
VALUES ('arsen', 'grigoryan', '0', true, 'ars', 'ars'),
('arman', 'grigoryan', '1', true, 'arm', 'arm');

INSERT INTO products (name, product_type_id, description, count_in_warehouse, count_in_shop, purchase_price, sale_price,
                      product_code, bar_code)
VALUES ('spichka', '9', 'haykakan lucki', 10, 5, '100', '110', '12345678', '87654321'),
('cello', '3', 'sev grich', 10, 5, '120', '130', '23456789', '98765432');

INSERT INTO product_type (name)
VALUES (''),
('Tey'),
('Makaron'),
('Grich'),
('Oxi'),
('Gini'),
('Kwnyak'),
('Tsxaxot'),
('Mastak'),
('Lwucki');


# ====================================================================================================================================================
#   SELECT
        # ====================================================================================================================================================
select *
From users;
select *
From products;
select *
From product_type;
select *
From info;

