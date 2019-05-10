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
                      product_code, barcode)
VALUES ('spichka', '9', 'haykakan lucki', '100', '110', '12345678', '87654321'),
       ('cello', '3', 'sev grich', '120', '130', '23456789', '98765432');

INSERT INTO quantity_of_product(barcode, count_in_warehouse, count_in_shop, count_of_sell)
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

# ====================================================================================================================================================
#   DELETE
# ====================================================================================================================================================
DELETE FROM products  WHERE product_code = '123456789' OR barcode = '87654321';


# ======================================================================================================================
# ======================================================================================================================
# ======================================================================================================================


SELECT p.id,
       p.name,
       p.description,
       p.purchase_price,
       p.sale_price,
       p.product_code,
       p.barcode,
       t.name,
       q.count_in_warehouse,
       q.count_in_shop,
       q.count_of_sell
FROM products AS p
         INNER JOIN product_type AS t ON p.product_type_id = t.id
         INNER JOIN quantity_of_product AS q ON p.barcode = q.barcode
WHERE q.barcode = 87654321;



SELECT i.id,
       i.barcode,
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
         INNER JOIN products AS p ON i.barcode = p.barcode
WHERE 1 = 1 AND
