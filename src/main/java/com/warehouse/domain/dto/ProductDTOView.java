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
public class ProductDTOView extends ProductDTO implements Serializable {
	private static final long serialVersionUID = 5776458177054327256L;

	private String productType;
	private Integer countInWarehouse;
	private Integer countInShop;
	private Integer countOfSell;

	public ProductDTOView(String productCode, String barcode, Integer countInWarehouse, Integer countInShop, Integer countOfSell) {
		super(productCode, barcode);
		this.countInWarehouse = countInWarehouse;
		this.countInShop = countInShop;
		this.countOfSell = countOfSell;
	}


}
