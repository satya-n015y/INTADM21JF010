package com.cognizant.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
 //@GeneratedValue(strategy = GenerationType.AUTO)
 @GeneratedValue(strategy = GenerationType.IDENTITY) 
 private Integer productId;
 
 @Column(name = "PRODUCT_NAME")
 private String productName;
 
 @Column(name = "PRODUCT_PRICE")
 private Float productPrice;
 
 public Product(String productName, Float productPrice) {
	 this.productName = productName;
	 this.productPrice = productPrice;
 }
}
