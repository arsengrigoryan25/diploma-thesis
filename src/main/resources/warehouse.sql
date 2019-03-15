
INSERT INTO `users` (`id`, `active`, `status`, `last_name`, `name`, `username`, `password`)
VALUES (1, true, '1', 'arsen', 'grigoryan', 'ars', 'ars'),
       (2, true, '1', 'arman', 'grigoryan', 'arm', 'arm');

-- Dumping data for table `role`
INSERT INTO `role` (`id`, `role`)
VALUES (1, 'ADMIN'),
       (2, 'USER');

-- Dumping data for table `user_role`
INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES (1, 1),
       (2, 2);
# ====================================================================================================================================================

-- ----------------------------------------------------------------------------------------------------------------

INSERT INTO products (id,name,type,description,count_in_warehouse,count_in_shop,purchase_price,sale_price,expiration_date,
                      product_code,bar_code)
VALUES (1, 'spichka', 'lucki', 'haykakan lucki', 10, 5, '100', '110', '2018-02-02', '12345678', '87654321'),
       (2, 'cello', 'grich', 'sev grich', 10, 5, '120', '130', '2018-02-02', '23456789', '98765432');


UPDATE products
SET count_in_warehouse = count_in_warehouse + '10' ,
    count_in_shop = count_in_shop + '10'
WHERE bar_code = '87654321';
commit ;





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