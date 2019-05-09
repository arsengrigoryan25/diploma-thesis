package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductView extends Product implements Serializable {

	private static final long serialVersionUID = 5776458177054327256L;
	private String productType;
	private Integer countInWarehouse;
	private Integer countInShop;
	private Integer countOfSell;

	public ProductView(Integer id, String name, String productTypeId, String description, String purchasePrice, String salePrice, String productCode, String barCode, String productType, Integer countInWarehouse, Integer countInShop, Integer countOfSell) {
		super(id, name, productTypeId, description, purchasePrice, salePrice, productCode, barCode);
		this.productType = productType;
		this.countInWarehouse = countInWarehouse;
		this.countInShop = countInShop;
		this.countOfSell = countOfSell;
	}

	public ProductView(String productCode, String barCode,  Integer countInWarehouse, Integer countInShop, Integer countOfSell) {
		super(productCode, barCode);
		this.countInWarehouse = countInWarehouse;
		this.countInShop = countInShop;
		this.countOfSell = countOfSell;
	}


}
