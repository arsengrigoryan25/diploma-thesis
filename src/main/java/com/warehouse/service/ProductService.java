package com.warehouse.service;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.filter.ProductFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

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
        jdbcTemplate.update(sql, product.getCount(), product.getBarCode());
    }

    public void updateProductsInShop(Product product) {

        String sql = " UPDATE products " +
                "SET count_in_warehouse = count_in_warehouse - ? , count_in_shop = count_in_shop + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCount(), product.getCount(), product.getBarCode());
    }

    public List<Product> searchProducts(ProductFilter filter) {

        StringBuilder queryBldr = new StringBuilder("SELECT * " +
                "FROM products AS p " +
                "WHERE 1=1");

        if (filter.getName() != null && !filter.getName().isEmpty()) {
            queryBldr.append(" and upper(p.NAME) LIKE %" + filter.getName().toUpperCase() + "%");
        }
        if (filter.getType() != null && !filter.getType().isEmpty()) {
            queryBldr.append(" and upper(p.TYPE) LIKE %" + filter.getType().toUpperCase() + "%");
        }
        if (filter.getAfterDate() != null) {
            queryBldr.append(" and p.EXPIRATION_DATE >=" + filter.getAfterDate());
        }
        if (filter.getBeforeDate() != null) {
            queryBldr.append(" and p.EXPIRATION_DATE <=" + filter.getBeforeDate());
        }
        if (filter.getProductCode() != null) {
            queryBldr.append(" and p.PRODUCT_CODE = " + filter.getProductCode());
        }
        if (filter.getBarCode() != null && !filter.getBarCode().isEmpty()) {
            queryBldr.append(" and p.BAR_COD = "+ filter.getBarCode());
        }

        jdbcTemplate.update(queryBldr.toString());

        return null;

//        if (filter.getBarCode() != null && !filter.getBarCode().isEmpty()) {
//            query.setParameter("firstName", "%" + filter.getFirstName().toUpperCase() + "%");
//        }
//        if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
//            query.setParameter("lastName", "%" + filter.getLastName().toUpperCase() + "%");
//        }
//        if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
//            query.setParameter("email", "%" + filter.getEmail().toUpperCase() + "%");
//        }
//        if (filter.getDateFrom() != null) {
//            query.setParameter("dateFrom", filter.getDateFrom());
//        }
//        if (filter.getDateTo() != null) {
//            query.setParameter("dateTo", filter.getDateTo());
//        }
//        if (!filter.getInited().isEmpty()) {
//            query.setParameter("inited", filter.getInited());
//        }
//
////        String sql = "SELECT p.*,d.name,d.description,i.url from products as p INNER JOIN product_descriptions as d  " +
////                "on (p.id = d.product_id) left join images i on p.id = i.product_id where d.lang_id=? and " + productIds + " p.category_id=? " +
////                "and (d.name like ? or d.description like ?) LIMIT ?,?";
////
////        keyword = "%" + keyword + "%";

    }
}
