package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

	private static final long serialVersionUID = 7142145741374776658L;
	private String name;
	private String type;
	private String description;
	private Integer count;
	private String purchasePrice;
	private String salePrice;
	private String productCode;
	private String barCode;

	public Product(Integer count, String productCode, String barCode) {
		this.count = count;
		this.productCode = productCode;
		this.barCode = barCode;
	}
}
