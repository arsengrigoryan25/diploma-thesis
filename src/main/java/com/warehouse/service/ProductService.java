package com.warehouse.service;

import com.warehouse.domain.dto.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    //    @Autowired
//    private  JdbcTemplate jdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createProducts(Product product) {

//        String sql = "INSERT INTO product (ID, DESCRIPTION, ID_COLUMN, NAME_COLUMN) VALUES ('RF_AGENCY', 'Agencies','ID', 'NAME')";
//        jdbcTemplate.update(sql,count, product_code );

    }

    public void updateProducts(Product product) {

        String sql = " UPDATE products " +
                "SET count_in_warehouse = count_in_warehouse + ? ,count_in_shop = count_in_shop + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCountInWarehouse(),product.getCountInShop(),product.getBarCode());
    }

    public void searchProducts() {

//        String sql = "SELECT p.*,d.name,d.description,i.url from products as p INNER JOIN product_descriptions as d  " +
//                "on (p.id = d.product_id) left join images i on p.id = i.product_id where d.lang_id=? and " + productIds + " p.category_id=? " +
//                "and (d.name like ? or d.description like ?) LIMIT ?,?";
//
//        keyword = "%" + keyword + "%";
//        jdbcTemplate.update(sql, 1, cid, keyword, keyword, (page - 1) * itemPerPage, itemPerPage);

    }


}
