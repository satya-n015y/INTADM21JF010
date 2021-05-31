package com.cognizant.college.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STUDENT")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUD_ID")
    private Long studId;
    
    @Column(name = "STUD_NAME")
    private String studName;
    
    @Column(name = "STUD_MOBILE")
    private String mobile;
    
    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department studDepartment;
}
