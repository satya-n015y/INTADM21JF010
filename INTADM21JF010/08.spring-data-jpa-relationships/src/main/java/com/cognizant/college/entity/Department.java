package com.cognizant.college.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "DEPT_ID")
 private Long deptId;
 
 @Column(name = "DEPT_NAME")
 private String deptName;
}
