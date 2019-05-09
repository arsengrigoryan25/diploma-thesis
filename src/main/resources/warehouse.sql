# ======================================================================================================================
#   CREATE DATABASE
# ======================================================================================================================
DROP DATABASE warehouse;
CREATE DATABASE warehouse CHARACTER SET utf8 COLLATE utf8_general_ci;
USE warehouse;

# ======================================================================================================================
#   CREATE TABLE
# ======================================================================================================================
#   DROP TABLE users;
#   DROP TABLE products;
#   DROP TABLE product_type;
#   DROP TABLE info;
#   DROP TABLE hibernate_sequence;

-- auto-generated definition
create table users
(
    id        bigint auto_increment
        primary key,
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
    id              int auto_increment
        primary key,
    bar_code        varchar(255) null,
    description     varchar(255) null,
    name            varchar(255) null,
    product_code    varchar(255) null,
    product_type_id varchar(255) null,
    purchase_price  varchar(255) null,
    sale_price      varchar(255) null,
    constraint UK_ks7bl2r407pphq72vxpufxqn
        unique (bar_code)
)
    engine = MyISAM;

-- auto-generated definition
create table product_type
(
    id   int auto_increment
        primary key,
    name varchar(255) null,
    constraint UK_bnu2aqss00w6he2vs4bmmy609
        unique (name)
)
    engine = MyISAM;

-- auto-generated definition
create table info
(
    id                       int auto_increment
        primary key,
    add_product_in_shop      int          null,
    add_product_in_warehouse int          null,
    bar_code                 varchar(255) null,
    change_date              datetime     null,
    count                    int          null,
    increment_or_decrement   bit          null,
    info                     varchar(255) null,
    product_code             varchar(255) null,
    sell                     int          null,
    constraint UK_5ffillxg8dtoukouhaip6nbb9
        unique (bar_code)
)
    engine = MyISAM;

-- auto-generated definition
create table quantity_of_product
(
    id                 int auto_increment
        primary key,
    bar_code           varchar(255) null,
    count_in_shop      int          null,
    count_in_warehouse int          null,
    count_of_sell      int          null,
    constraint UK_qu33mhl9ayyvf35pbjbai709x
        unique (bar_code)
)
    engine = MyISAM;

-- auto-generated definition
create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;


# ======================================================================================================================
#   CLEAN DATA in TABLE
# ======================================================================================================================
TRUNCATE TABLE users;
TRUNCATE TABLE products;
TRUNCATE TABLE product_type;
TRUNCATE TABLE info;


# ======================================================================================================================
#   INSERT
# ======================================================================================================================
INSERT INTO users (last_name, name, role, active, username, password)
VALUES ('arsen', 'grigoryan', '0', true, 'ars', 'ars'),
       ('arman', 'grigoryan', '1', true, 'arm', 'arm');

INSERT INTO products (name, product_type_id, description, purchase_price, sale_price,
                      product_code, bar_code)
VALUES ('spichka', '9', 'haykakan lucki', '100', '110', '12345678', '87654321'),
       ('cello', '3', 'sev grich', '120', '130', '23456789', '98765432');

INSERT INTO quantity_of_product(bar_code, count_in_warehouse, count_in_shop, count_of_sell)
VALUES ('87654321', 2, 3, 0),
       ('98765432', 2, 3, 0);

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


# ======================================================================================================================
#   SELECT
# ======================================================================================================================
SELECT *
FROM users;
SELECT *
FROM products;
SELECT *
FROM product_type;
SELECT *
FROM info;
SELECT *
FROM quantity_of_product;
# ======================================================================================================================
# ======================================================================================================================
# ======================================================================================================================


SELECT p.id,
       p.name,
       p.description,
       p.purchase_price,
       p.sale_price,
       p.product_code,
       p.bar_code,
       t.name,
       q.count_in_warehouse,
       q.count_in_shop,
       q.count_of_sell
FROM products AS p
         INNER JOIN product_type AS t ON p.product_type_id = t.id
         INNER JOIN quantity_of_product AS q ON p.bar_code = q.bar_code
WHERE q.bar_code = 87654321;



SELECT i.id,
       i.bar_code,
       i.product_code,
       i.increment_or_decrement,
       i.change_date,
       i.add_product_in_warehouse,
       i.add_product_in_shop,
       i.sell,
       i.count,
       i.info,
       p.name
FROM info AS i
         INNER JOIN products AS p ON i.bar_code = p.bar_code
WHERE 1 = 1 AND
