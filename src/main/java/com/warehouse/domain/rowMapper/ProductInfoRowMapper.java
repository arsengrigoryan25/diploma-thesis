package com.warehouse.domain.rowMapper;

import com.warehouse.domain.dto.InfoDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductInfoRowMapper implements RowMapper<InfoDTO> {
    @Override
    public InfoDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        InfoDTO infoDto = new InfoDTO();
        infoDto.setId(resultSet.getInt("id"));
        infoDto.setName(resultSet.getString("name"));
        infoDto.setBarcode(resultSet.getString("barcode"));
        infoDto.setIncrementOrDecrement(resultSet.getBoolean("increment_or_decrement"));
        infoDto.setChangeDate(resultSet.getDate("change_date"));
        infoDto.setAddProductInWarehouse(resultSet.getInt("add_product_in_warehouse"));
        infoDto.setAddProductInShop(resultSet.getInt("add_product_in_shop"));
        infoDto.setSell(resultSet.getInt("sell"));
        infoDto.setCount(resultSet.getInt("count"));
        infoDto.setInfo(resultSet.getString("info"));

        return infoDto;
    }
}
