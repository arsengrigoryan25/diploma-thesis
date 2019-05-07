package com.warehouse.service;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.domain.rowMapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductService {

    @Inject
    private EntityManager em;

    private final JdbcTemplate jdbcTemplate;

    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateProductsInWarehouse(Product product) {

        String sql = " UPDATE products " +
                "SET count_in_warehouse = count_in_warehouse + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCountInWarehouse(), product.getBarCode());
    }

    public void updateProductsInShop(Product product) {

        String sql = " UPDATE products " +
                "SET count_in_warehouse = count_in_warehouse - ? , count_in_shop = count_in_shop + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCountInWarehouse(), product.getCountInShop(), product.getBarCode());
    }

    public List<Product> searchProducts(ProductFilter filter) {

        StringBuilder queryBldr = new StringBuilder("SELECT " +
                "       p.id," +
                "       p.name, " +
                "       p.description, " +
                "       p.count_in_warehouse, " +
                "       p.count_in_shop, " +
                "       p.purchase_price, " +
                "       p.sale_price, " +
                "       p.product_code, " +
                "       p.bar_code, " +
                "       t.name " +
                " FROM products AS p " +
                "       INNER JOIN product_type AS t ON p.product_type_id = t.id " +
                " WHERE 1 = 1 ");

        if (filter.getName() != null && !filter.getName().isEmpty()) {
            queryBldr.append(" AND upper(p.NAME) LIKE % ").append(filter.getName().toUpperCase()).append(" %");
        }
        if (filter.getType() != null && !filter.getType().isEmpty() && !filter.getType().equals("1")) {
            queryBldr.append(" AND p.product_type_id = ").append(filter.getType());
        }
        if (filter.getProductCode() != null && !filter.getProductCode().isEmpty()) {
            queryBldr.append(" AND p.product_code = ").append(filter.getProductCode());
        }
        if (filter.getBarCode() != null && !filter.getBarCode().isEmpty()) {
            queryBldr.append(" AND p.bar_code = ").append(filter.getBarCode());
        }

        return jdbcTemplate.query(queryBldr.toString(), new ProductRowMapper());
    }
}
