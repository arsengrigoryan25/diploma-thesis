package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InfoDTO implements Serializable {
	private static final long serialVersionUID = 3469191458545676778L;

	private Integer id;
	private String name;
	private String barcode;
	private String productCode;
	private Date changeDate;
	private Boolean incrementOrDecrement;        // Եթե ավելացվում է true, եթե պակասեցվում է false
	private Integer addProductInWarehouse;
	private Integer addProductInShop;
	private Integer sell;
	private Integer count;
	private String info;

}