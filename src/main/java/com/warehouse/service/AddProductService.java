package com.warehouse.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AddProductService {
//    @Autowired
//    private  JdbcTemplate jdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public AddProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateProducts(String count, String product_code){

        String sql = "UPDATE products_in_warehouse SET count = ? WHERE product_code = ?";
        jdbcTemplate.update(sql,count, product_code );

    }

}
