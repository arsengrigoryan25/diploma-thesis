INSERT INTO users (id, active, last_name, name, username, password)
VALUES (1, true,'arsen', 'grigoryan', 'ars', 'ars'),
       (2, true,'arman', 'grigoryan', 'arm', 'arm');

-- Dumping data for table role
INSERT INTO role (id, role)
VALUES (1, 'ADMIN'),
       (2, 'USER');

-- Dumping data for table user_role
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (2, 2);
# ====================================================================================================================================================
INSERT INTO products (id, name, product_type_id, description, count_in_warehouse, count_in_shop, purchase_price, sale_price,
                      product_code, bar_code)
VALUES (1, 'spichka', '9', 'haykakan lucki', 10, 5, '100', '110', '12345678', '87654321'),
       (2, 'cello', '3', 'sev grich', 10, 5, '120', '130', '23456789', '98765432');

INSERT INTO type (id, name)
VALUES (1, 'Tey'),
       (2, 'Makaron'),
       (3, 'Grich'),
       (4, 'Oxi'),
       (5, 'Gini'),
       (6, 'Kwnyak'),
       (7, 'Tsxaxot'),
       (8, 'Mastak'),
       (9, 'Lwucki');



# -------------------------------------------------------------------

INSERT INTO users (id, last_name, name, role, active, username, password)
VALUES (1, 'arsen', 'grigoryan', 0, true,'ars', 'ars'),
       (2, 'arman', 'grigoryan', 1, true,'arm', 'arm');

INSERT INTO products (id, name, product_type_id, description, count_in_warehouse, count_in_shop, purchase_price, sale_price,
                      product_code, bar_code)
VALUES (1, 'spichka', '9', 'haykakan lucki', 10, 5, '100', '110', '12345678', '87654321'),
       (2, 'cello', '3', 'sev grich', 10, 5, '120', '130', '23456789', '98765432');

INSERT INTO product_type (id, name)
VALUES (1, 'Tey'),
       (2, 'Makaron'),
       (3, 'Grich'),
       (4, 'Oxi'),
       (5, 'Gini'),
       (6, 'Kwnyak'),
       (7, 'Tsxaxot'),
       (8, 'Mastak'),
       (9, 'Lwucki');



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