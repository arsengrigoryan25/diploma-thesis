package com.warehouse.domain.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;

@Entity
@Table(name = "products_in_warehouse")
public class ProductInWarehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private String name;
	private String type;
	private String description;
	private String countInWarehouse;
	private String purchasePrice;
	private String salePrice;
	private String expirationDate;
	private String productCode;
	private String barcode;

	public ProductInWarehouse() {
	}
    public ProductInWarehouse(String name, String type, String description, String countInWarehouse, String purchasePrice, String salePrice, String expirationDate, String productCode, String barcode) {
        this.name = name;
        this.type = type;
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
