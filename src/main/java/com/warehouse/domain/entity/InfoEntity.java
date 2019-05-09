package com.warehouse.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "info")
public class InfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(unique = true)
	private String barCode;
	private String productCode;
	private Date changeDate;
	private Boolean incrementOrDecrement;		// Եթե ավելացվում է true, եթե պակասեցվում է false
	private Integer addProductInWarehouse;
	private Integer addProductInShop;
	private Integer sell;
	private Integer count;
	private String info;

	public InfoEntity(Date changeDate, String info) {
		this.changeDate = changeDate;
		this.info = info;
	}

	public InfoEntity(Date changeDate,  String productCode, String barCode, String info) {
		this.changeDate = changeDate;
		this.barCode = barCode;
		this.productCode = productCode;
		this.info = info;
	}

	public InfoEntity(Date changeDate, String barCode, Boolean incrementOrDecrement, Integer addProductInWarehouse, Integer addProductInShop, Integer sell, Integer count, String info) {
		this.changeDate = changeDate;
		this.barCode = barCode;
		this.incrementOrDecrement = incrementOrDecrement;
		this.addProductInWarehouse = addProductInWarehouse;
		this.addProductInShop = addProductInShop;
		this.sell = sell;
		this.count = count;
		this.info = info;
	}
}