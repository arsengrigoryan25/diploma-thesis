package com.warehouse.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	private String name;
	private String productTypeId;
	private String description;
	private Integer countInWarehouse;
	private Integer countInShop;
	private String purchasePrice;
	private String salePrice;
	private String productCode;
	@Column(unique = true)
	private String barCode;

	public ProductEntity(String name, String productTypeId, String description, Integer countInWarehouse, Integer countInShop, String purchasePrice, String salePrice, String productCode, String barCode) {
		this.name = name;
		this.productTypeId = productTypeId;
		this.description = description;
		this.countInWarehouse = countInWarehouse;
		this.countInShop = countInShop;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.productCode = productCode;
		this.barCode = barCode;
	}

}