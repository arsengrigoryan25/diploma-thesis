package com.warehouse.domain.dto;

public class ProductInShop {

	private int id;
	private String name;
	private String type;
	private String description;
	private String count;
	private String salePrice;
	private String expirationDate;
	private String productCode;
	private String barcode;

	public ProductInShop() {
	}
	public ProductInShop(String name, String type, String description, String count, String salePrice,
						 String expirationDate, String productCode, String barcode) {
		this.name = name;
		this.type = type;
		this.description = description;
		this.count = count;
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

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
