package com.cognizant.college;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.college.entity.Department;
import com.cognizant.college.entity.Student;
import com.cognizant.college.repository.DepartmentRepository;
import com.cognizant.college.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		DepartmentRepository departmentRepo = context.getBean(DepartmentRepository.class);
		StudentRepository studentRepo = context.getBean(StudentRepository.class);
		
		 Department dept1 = new Department();
		 dept1.setDeptName("COMPUTER");
		 
		 Department dept2 = new Department();
		 dept2.setDeptName("ELECTRONICS"); 
		 
		 departmentRepo.saveAll(Arrays.asList(dept1,dept2));
		 
		 Student stud1 = new Student();
		 stud1.setStudName("Sunil Joseph");
		 stud1.setMobile("9848586878");
		 stud1.setStudDepartment(departmentRepo.findByDeptName("COMPUTER"));
		 
		 Student stud2 = new Student();
		 stud2.setStudName("Anil Kumar");
		 stud2.setMobile("7848586878");
		 stud2.setStudDepartment(departmentRepo.findByDeptName("COMPUTER"));
		 
		 Student stud3 = new Student();
		 stud3.setStudName("Praveen Kumar");
		 stud3.setMobile("6848586878");
		 stud3.setStudDepartment(departmentRepo.findByDeptName("ELECTRONICS"));
		 
		 studentRepo.saveAll(Arrays.asList(stud1,stud2,stud3));
		 
		 context.close();
	}

}
