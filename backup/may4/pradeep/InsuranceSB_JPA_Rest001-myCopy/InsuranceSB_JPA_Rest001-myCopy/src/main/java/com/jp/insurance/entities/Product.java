package com.jp.insurance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {

	@SequenceGenerator(name="PRODUCT_GEN", sequenceName="PRODUCT_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PRODUCT_GEN")
    @Id
    @Column(name="PRODUCT_NUMBER")
    private Integer productNumber;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="PRODUCT_PRICE")
    private Double productPrice;

    @Column(name="PRODUCT_TYPE")
    private String productType;

	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Product(Integer productNumber, String productName, Double productPrice, String productType) {
		super();
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productType=" + productType + "]";
	}

    


}
