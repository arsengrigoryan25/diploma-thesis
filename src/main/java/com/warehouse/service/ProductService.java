package com.warehouse.service;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.dto.ProductView;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.domain.rowMapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Inject
    private EntityManager em;

    private final JdbcTemplate jdbcTemplate;

    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateProductsInWarehouse(ProductView product) {

        String sql = " UPDATE  quantity_of_product " +
                "SET count_in_warehouse = count_in_warehouse + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCountInWarehouse(), product.getBarCode());
    }

    public void updateProductsInShop(ProductView product) {

        String sql = " UPDATE quantity_of_product " +
                "SET count_in_warehouse = count_in_warehouse - ? , count_in_shop = count_in_shop + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCountInShop(), product.getCountInShop(), product.getBarCode());
    }

    public void updateProductsSell(ProductView product) {

        String sql = " UPDATE quantity_of_product " +
                "SET count_of_sell = count_of_sell + ? " +
                "WHERE bar_code = ? ";
        jdbcTemplate.update(sql, product.getCountOfSell(), product.getBarCode());
    }

    public List<Product> searchProducts(ProductFilter filter) {

        StringBuilder queryBldr = new StringBuilder("SELECT " +
                "       p.id," +
                "       p.name, " +
                "       p.description, " +
                "       p.purchase_price, " +
                "       p.sale_price, " +
                "       p.product_code, " +
                "       p.bar_code, " +
                "       t.name," +
                "       q.count_in_warehouse, " +
                "       q.count_in_shop, " +
                "       q.count_of_sell " +
                " FROM products AS p " +
                "       INNER JOIN product_type AS t ON p.product_type_id = t.id " +
                "       INNER JOIN quantity_of_product AS q ON p.bar_code = q.bar_code " +
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

    public void deleteProducts(ProductFilter filter) {

        StringBuilder queryBldr = new StringBuilder(" DELETE FROM products WHERE bar_code = ");


        if (filter.getBarCode() != null && !filter.getBarCode().isEmpty()) {
            queryBldr.append(filter.getBarCode());
        }
        if (filter.getProductCode() != null && !filter.getProductCode().isEmpty()) {
            queryBldr.append("OR product_code =").append(filter.getProductCode());
        }

        jdbcTemplate.execute(queryBldr.toString());
    }

    public int getCountProductInWarehouseByBarcode(String barCode) {

        StringBuilder queryBldr = new StringBuilder("SELECT q.count_in_warehouse " +
                "FROM quantity_of_product q " +
                "WHERE 1=1 ");
        if (!barCode.trim().isEmpty()) {
            queryBldr.append("AND bar_code =" + barCode);
        }

        return jdbcTemplate.queryForObject(queryBldr.toString(), Integer.class);
    }


    public int getCountProductInShopByBarcode(String barCode) {

        StringBuilder queryBldr = new StringBuilder("SELECT q.count_in_shop " +
                "FROM quantity_of_product q " +
                "WHERE 1=1 ");
        if (!barCode.trim().isEmpty()) {
            queryBldr.append("AND bar_code =" + barCode);
        }

        return jdbcTemplate.queryForObject(queryBldr.toString(), Integer.class);
    }

    public ProductView getProductInfo(String barCode, Date startDAte, Date endDate) {

        StringBuilder queryBldr = new StringBuilder("SELECT i.id," +
                "i.bar_code," +
                "i.product_code," +
                "i.increment_or_decrement," +
                "i.change_date," +
                "i.add_product_in_warehouse," +
                "i.add_product_in_shop," +
                "i.sell," +
                "i.count," +
                "i.info," +
                "p.name" +
                "FROM info AS i" +
                "INNER JOIN products AS p ON i.bar_code = p.bar_code" +
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
