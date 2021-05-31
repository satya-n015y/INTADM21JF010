package com.cognizant.contacts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONTACTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact {
 @Id
 @GeneratedValue
 @Column(name = "CONTACT_ID")
 private Integer contactId;
 
 @Column(name = "CONTACT_NAME")
 private String contactName;
 
 @Column(name = "CONTACT_EMAIL")
 private String contactEmail;
}
