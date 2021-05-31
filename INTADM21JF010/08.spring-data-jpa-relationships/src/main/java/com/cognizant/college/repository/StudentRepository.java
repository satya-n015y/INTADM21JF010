package com.cognizant.college.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.college.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable> {

}
