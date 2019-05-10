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
@Table(name = "quantity_of_product")
public class QuantityOfProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(unique = true)
	private String barcode;
	private Integer countInWarehouse;
	private Integer countInShop;
	private Integer countOfSell;

	public QuantityOfProductEntity(String barcode, Integer countInWarehouse, Integer countInShop, Integer countOfSell) {
		this.barcode = barcode;
		this.countInWarehouse = countInWarehouse;
		this.countInShop = countInShop;
		this.countOfSell = countOfSell;
	}
}