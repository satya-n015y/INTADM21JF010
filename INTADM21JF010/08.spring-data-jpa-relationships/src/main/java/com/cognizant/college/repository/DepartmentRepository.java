package com.cognizant.college.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.college.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Serializable> {

	Department findByDeptName(String string);

}
