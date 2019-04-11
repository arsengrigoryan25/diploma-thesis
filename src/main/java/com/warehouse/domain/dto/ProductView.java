package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductView extends Product implements Serializable {

	private static final long serialVersionUID = 5776458177054327256L;
	private String productType;

}
