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
	@Column(unique = true)
	private String barcode;
	private String name;
	private String productTypeId;
	private String description;
	private String purchasePrice;
	private String salePrice;
	private String productCode;


	public ProductEntity(String name, String productTypeId, String description, String purchasePrice, String salePrice, String productCode, String barcode) {
		this.name = name;
		this.productTypeId = productTypeId;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.productCode = productCode;
		this.barcode = barcode;
	}

}