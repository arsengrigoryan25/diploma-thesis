package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.omg.CORBA.INTERNAL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

	private static final long serialVersionUID = 5776458177054327256L;
	private Integer id;
	private String name;
	private String productTypeId;
	private String description;
	private String purchasePrice;
	private String salePrice;
	private String productCode;
	private String barCode;

	public Product(String name, String productTypeId, String productCode, String barCode) {
		this.name = name;
		this.productTypeId = productTypeId;
		this.productCode = productCode;
		this.barCode = barCode;
	}

	public Product(String productCode, String barCode) {
		this.productCode = productCode;
		this.barCode = barCode;
	}
}
