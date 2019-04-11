package com.warehouse.domain.rowMapper;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.dto.ProductView;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public ProductView mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductView productView = new ProductView();
        productView.setId(resultSet.getInt("id"));
        productView.setName(resultSet.getString("name"));
        productView.setBarCode(resultSet.getString("bar_code"));
        productView.setCountInShop(resultSet.getInt("count_in_shop"));
        productView.setCountInWarehouse(resultSet.getInt("count_in_warehouse"));
        productView.setDescription(resultSet.getString("description"));
        productView.setProductCode(resultSet.getString("product_code"));
        productView.setProductType(resultSet.getString("name"));
        productView.setPurchasePrice(resultSet.getString("purchase_price"));
        productView.setSalePrice(resultSet.getString("sale_price"));
        return productView;
    }
}
