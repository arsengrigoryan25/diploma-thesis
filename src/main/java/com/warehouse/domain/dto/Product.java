package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

	private static final long serialVersionUID = 7142145741374776658L;
	private String name;
	private String type;
	private String description;
	private Integer countInWarehouse;
	private Integer countInShop;
	private String purchasePrice;
	private String salePrice;
	private String expirationDate;
	private String productCode;
	private String barCode;

	public Product(Integer countInWarehouse, Integer countInShop, String productCode, String barCode) {
		this.countInWarehouse = countInWarehouse;
		this.countInShop = countInShop;
		this.productCode = productCode;
		this.barCode = barCode;
	}
}
