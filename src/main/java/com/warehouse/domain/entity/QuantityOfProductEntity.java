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
	private String barCode;
	private Integer countInWarehouse;
	private Integer countInShop;
	private Integer countOfSell;

	public QuantityOfProductEntity(String barCode, Integer countInWarehouse, Integer countInShop, Integer countOfSell) {
		this.barCode = barCode;
		this.countInWarehouse = countInWarehouse;
		this.countInShop = countInShop;
		this.countOfSell = countOfSell;
	}
}