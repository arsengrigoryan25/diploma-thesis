package com.warehouse.service;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.dto.TypeProducts;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.TypeProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplateTest;

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

        StringBuilder queryBldr = new StringBuilder("SELECT p.id," +
                "       p.name, " +
                "       p.description, " +
                "       p.count_in_warehouse, " +
                "       p.count_in_shop, " +
                "       p.bar_code, " +
                "       p.product_code, " +
                "       p.purchase_price, " +
                "       p.sale_price, " +
                "       t.name " +
                "FROM products AS p " +
                "       INNER JOIN type as t ON p.type_id = t.id " +
                "WHERE 1 = 1");

        if (filter.getName() != null && !filter.getName().isEmpty()) {
            queryBldr.append(" and upper(p.NAME) LIKE %" + filter.getName().toUpperCase() + "%");
        }
        if (filter.getType() != null && !filter.getType().isEmpty()) {
            queryBldr.append(" and p.TYPE_ID = " + filter.getType());
        }
        if (filter.getProductCode() != null) {
            queryBldr.append(" and p.PRODUCT_CODE = " + filter.getProductCode());
        }
        if (filter.getBarCode() != null && !filter.getBarCode().isEmpty()) {
            queryBldr.append(" and p.BAR_COD = " + filter.getBarCode());
        }

        List<Product> productList = jdbcTemplate.queryForList(queryBldr.toString(), Product.class);

        return productList;
    }

    public void updateTypeProduct(List<TypeProducts> typeProducts){

    }

}
