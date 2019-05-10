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
public class ProductTypeDTO implements Serializable {
	private static final long serialVersionUID = -6739739389089828179L;

	private Integer id;
	private String name;
}