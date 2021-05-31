package com.cognizant.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_DTLS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
 @Id
 @Column(name = "PRODUCT_ID") 
 @GenericGenerator(name = "prodIdGen", 
                   strategy = "com.cognizant.inventory.generator.ProductIdGenerator")
 @GeneratedValue(generator = "prodIdGen")
 private String productId;
 
 @Column(name = "PRODUCT_NAME")
 private String productName;
 
 @Column(name = "PRODUCT_PRICE")
 private Float productPrice;
 
 public Product(String productName, Float productPrice) {
	 this.productName = productName;
	 this.productPrice = productPrice;
 }
}
