package com.warehouse.service;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.filter.ProductFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.Query;

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

    public void updateProductsInWarehouse(Product product) {

        String sql = " UPDATE products " +
                "SET count_in_warehouse = count_in_warehouse + ?" +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCount(),product.getBarCode());
    }

    public void updateProductsInShop(Product product) {

        String sql = " UPDATE products " +
                "SET count_in_warehouse = count_in_warehouse - ? , count_in_shop = count_in_shop + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCount(),product.getCount(),product.getBarCode());
    }

    public void searchProducts(ProductFilter filter) {


        StringBuilder queryBldr = new StringBuilder("

        if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()) {
            queryBldr.append(" and upper(u.FIRST_NAME) LIKE :firstName");
        }
        if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
            queryBldr.append(" and upper(u.LAST_NAME) LIKE :lastName");
        }
        if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
            queryBldr.append(" and upper(u.EMAIL) LIKE :email");
        }
        if (filter.getDateFrom() != null) {
            queryBldr.append(" and u.CREATE_DATA >= :dateFrom");
        }
        if (filter.getDateTo() != null) {
            queryBldr.append(" and u.CREATE_DATA <= :dateTo");
        }
        if (!filter.getInited().isEmpty()) {
            queryBldr.append(" and u.INITED = :inited ");
        }

        Query query = hatisEM.createNativeQuery(queryBldr.toString());

        if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()) {
            query.setParameter("firstName", "%" + filter.getFirstName().toUpperCase() + "%");
        }
        if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
            query.setParameter("lastName", "%" + filter.getLastName().toUpperCase() + "%");
        }
        if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
            query.setParameter("email", "%" + filter.getEmail().toUpperCase() + "%");
        }
        if (filter.getDateFrom() != null) {
            query.setParameter("dateFrom", filter.getDateFrom());
        }
        if (filter.getDateTo() != null) {
            query.setParameter("dateTo", filter.getDateTo());
        }
        if (!filter.getInited().isEmpty()) {
            query.setParameter("inited", filter.getInited());
        }

        String sql = "SELECT p.*,d.name,d.description,i.url from products as p INNER JOIN product_descriptions as d  " +
                "on (p.id = d.product_id) left join images i on p.id = i.product_id where d.lang_id=? and " + productIds + " p.category_id=? " +
                "and (d.name like ? or d.description like ?) LIMIT ?,?";

        keyword = "%" + keyword + "%";
        jdbcTemplate.update(sql, 1, cid, keyword, keyword, (page - 1) * itemPerPage, itemPerPage);

    }


}
