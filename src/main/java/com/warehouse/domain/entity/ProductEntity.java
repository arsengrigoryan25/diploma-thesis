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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	private String name;
	private String type;
	private String description;
	private String countInWarehouse;
	private String countInShop;
	private String purchasePrice;
	private String salePrice;
	private String expirationDate;
	private String productCode;
	private String barcode;

    public ProductEntity(String name,
						 String type,
						 String description,
						 String countInWarehouse,
						 String countInShop,
						 String purchasePrice,
						 String salePrice,
						 String expirationDate,
						 String productCode,
						 String barcode) {
    }
}
