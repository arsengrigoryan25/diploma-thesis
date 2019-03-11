package com.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
//    @Autowired
//    private  JdbcTemplate jdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public SearchService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateProducts(int cid, int page, int itemPerPage, String productIds, String keyword){

        String sql = "SELECT p.*,d.name,d.description,i.url from products as p INNER JOIN product_descriptions as d  " +
                "on (p.id = d.product_id) left join images i on p.id = i.product_id where d.lang_id=? and " + productIds + " p.category_id=? " +
                "and (d.name like ? or d.description like ?) LIMIT ?,?";

        keyword = "%"+keyword+"%";
        jdbcTemplate.update(sql, 1, cid,keyword,keyword, (page - 1) * itemPerPage, itemPerPage);

    }

}
