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
	private String barcode;
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

	public InfoEntity(Date changeDate,  String productCode, String barcode, String info) {
		this.changeDate = changeDate;
		this.barcode = barcode;
		this.productCode = productCode;
		this.info = info;
	}

	public InfoEntity(Date changeDate, String barcode, Boolean incrementOrDecrement, Integer addProductInWarehouse, Integer addProductInShop, Integer sell, Integer count, String info) {
		this.changeDate = changeDate;
		this.barcode = barcode;
		this.incrementOrDecrement = incrementOrDecrement;
		this.addProductInWarehouse = addProductInWarehouse;
		this.addProductInShop = addProductInShop;
		this.sell = sell;
		this.count = count;
		this.info = info;
	}
}