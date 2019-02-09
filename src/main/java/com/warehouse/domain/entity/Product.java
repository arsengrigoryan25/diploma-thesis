package com.warehouse.domain.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "count_in_warehouse")
	private String countInWarehouse;

	@Column(name = "purchase_price")
	private String purchasePrice;

	@Column(name = "sale_price")
	private String salePrice;

	@Column(name = "expiration_date")
	private String expirationDate;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "barcode")
	private String barcode;

	public Product(String name, String description, String countInWarehouse, String purchasePrice, String salePrice, String expirationDate, String productCode, String barcode) {
		this.name = name;
		this.description = description;
		this.countInWarehouse = countInWarehouse;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.expirationDate = expirationDate;
		this.productCode = productCode;
		this.barcode = barcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountInWarehouse() {
		return countInWarehouse;
	}

	public void setCountInWarehouse(String countInWarehouse) {
		this.countInWarehouse = countInWarehouse;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
