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
@Table(name = "products_in_shop")
public class ProductInShopEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	private String name;
	private String type;
	private String count;
	private String salePrice;
	private String expirationDate;
	private String productCode;
	private String barcode;

	public ProductInShopEntity(String name, String type, String count, String salePrice, String expirationDate, String productCode, String barcode) {
	}
}
