package com.warehouse.domain.rowMapper;

import com.warehouse.domain.dto.ProductDTOView;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductDTOView> {
    @Override
    public ProductDTOView mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductDTOView productView = new ProductDTOView();
        productView.setId(resultSet.getInt("id"));
        productView.setName(resultSet.getString("name"));
        productView.setBarcode(resultSet.getString("barcode"));
        productView.setDescription(resultSet.getString("description"));
        productView.setProductCode(resultSet.getString("product_code"));
        productView.setPurchasePrice(resultSet.getString("purchase_price"));
        productView.setSalePrice(resultSet.getString("sale_price"));
        productView.setProductType(resultSet.getString("name"));
        productView.setCountInShop(resultSet.getInt("count_in_shop"));
        productView.setCountInWarehouse(resultSet.getInt("count_in_warehouse"));
        productView.setCountOfSell(resultSet.getInt("count_of_sell"));

        return productView;
    }
}
