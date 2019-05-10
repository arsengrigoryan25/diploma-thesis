package com.warehouse.service;

import com.warehouse.domain.dto.InfoDTO;
import com.warehouse.domain.dto.ProductDTO;
import com.warehouse.domain.dto.ProductDTOView;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.domain.filter.ProductInfoFilter;
import com.warehouse.domain.rowMapper.ProductInfoRowMapper;
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

    public void updateProductsInWarehouse(ProductDTOView product) {

        String sql = " UPDATE  quantity_of_product " +
                "SET count_in_warehouse = count_in_warehouse + ? " +
                "WHERE barcode = ? ";
        jdbcTemplate.update(sql, product.getCountInWarehouse(), product.getBarcode());
    }

    public void updateProductsInShop(ProductDTOView product) {

        String sql = " UPDATE quantity_of_product " +
                "SET count_in_warehouse = count_in_warehouse - ? , count_in_shop = count_in_shop + ? " +
                "WHERE barcode = ? ";
        jdbcTemplate.update(sql, product.getCountInShop(), product.getCountInShop(), product.getBarcode());
    }

    public void updateProductsSell(ProductDTOView product) {

        String sql = " UPDATE quantity_of_product " +
                "SET count_of_sell = count_of_sell + ?, count_in_shop = count_in_shop - ?  " +
                "WHERE barcode = ? ";
        jdbcTemplate.update(sql, product.getCountOfSell(), product.getCountOfSell(), product.getBarcode());
    }

    public List<ProductDTOView> searchProducts(ProductFilter filter) {

        StringBuilder queryBldr = new StringBuilder("SELECT " +
                "       p.id," +
                "       p.name, " +
                "       p.description, " +
                "       p.purchase_price, " +
                "       p.sale_price, " +
                "       p.product_code, " +
                "       p.barcode, " +
                "       t.name," +
                "       q.count_in_warehouse, " +
                "       q.count_in_shop, " +
                "       q.count_of_sell " +
                " FROM products AS p " +
                "       INNER JOIN product_type AS t ON p.product_type_id = t.id " +
                "       INNER JOIN quantity_of_product AS q ON p.barcode = q.barcode " +
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
        if (filter.getBarcode() != null && !filter.getBarcode().isEmpty()) {
            queryBldr.append(" AND p.barcode = ").append(filter.getBarcode());
        }

        return jdbcTemplate.query(queryBldr.toString(), new ProductRowMapper());
    }

    public void deleteProducts(ProductFilter filter) {

        StringBuilder queryBldr = new StringBuilder(" DELETE FROM products WHERE barcode = ");

        if (filter.getBarcode() != null && !filter.getBarcode().isEmpty()) {
            queryBldr.append(filter.getBarcode());
        }
        if (filter.getProductCode() != null && !filter.getProductCode().isEmpty()) {
            queryBldr.append("OR product_code =").append(filter.getProductCode());
        }

        jdbcTemplate.execute(queryBldr.toString());
    }


    public int getCountProductInWarehouseByBarcode(String barcode) {

        StringBuilder queryBldr = new StringBuilder("SELECT q.count_in_warehouse " +
                "FROM quantity_of_product q " +
                "WHERE 1=1 ");
        if (!barcode.trim().isEmpty()) {
            queryBldr.append("AND barcode =" + barcode);
        }

        return jdbcTemplate.queryForObject(queryBldr.toString(), Integer.class);
    }

    public int getCountProductInShopByBarcode(String barcode) {

        StringBuilder queryBldr = new StringBuilder("SELECT q.count_in_shop " +
                "FROM quantity_of_product q " +
                "WHERE 1=1 ");
        if (!barcode.trim().isEmpty()) {
            queryBldr.append("AND barcode =" + barcode);
        }

        return jdbcTemplate.queryForObject(queryBldr.toString(), Integer.class);
    }

    public int getCountProductOfSellByBarcode(String barcode) {

        StringBuilder queryBldr = new StringBuilder("SELECT q.count_of_sell " +
                "FROM quantity_of_product q " +
                "WHERE 1=1 ");
        if (!barcode.trim().isEmpty()) {
            queryBldr.append("AND barcode =" + barcode);
        }

        return jdbcTemplate.queryForObject(queryBldr.toString(), Integer.class);
    }


    public List<InfoDTO> getProductInfo(ProductInfoFilter filter) {

        StringBuilder queryBldr = new StringBuilder("SELECT i.id," +
                "   i.barcode, " +
                "   i.product_code, " +
                "   i.increment_or_decrement, " +
                "   i.change_date, " +
                "   i.add_product_in_warehouse, " +
                "   i.add_product_in_shop, " +
                "   i.sell, " +
                "   i.count, " +
                "   i.info, " +
                "   p.name " +
                " FROM info AS i " +
                "   INNER JOIN products AS p ON i.barcode = p.barcode" +
                "   WHERE 1 = 1 ");

        if (!filter.getBarcode().trim().isEmpty()) {
            queryBldr.append(" AND p.barcode = " + filter.getBarcode());
        }

        if (filter.getStartDate() != null) {
            queryBldr.append(" AND i.change_date >= " + filter.getStartDate());
        }

        if (filter.getEndDate() != null) {
            queryBldr.append(" AND i.change_date <= " + filter.getEndDate());
        }

        return jdbcTemplate.query(queryBldr.toString(), new ProductInfoRowMapper());
    }
}
