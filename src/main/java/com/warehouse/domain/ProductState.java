package com.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductState implements Serializable {
	private static final long serialVersionUID = -5726169290888647681L;

	private int id;
	private String name;
}
