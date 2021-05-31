package com.cognizant.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.inventory.entity.Product;
import com.cognizant.inventory.repository.ProductRepository;

@SpringBootApplication
public class Application {
	private static ProductRepository productRepo; 	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		productRepo = context.getBean(ProductRepository.class);
		
		Product product1 = new Product("Mobile", 25000f);
		Product product2 = new Product("Keyborad", 475.5f);
		Product product3 = new Product("Mouse", 150.75f);
		Product product4 = new Product("Hard Disk", 3250.5f);
		
		Product savedProduct = productRepo.save(product1);
		System.out.println(savedProduct);
		
		savedProduct = productRepo.save(product2);
		System.out.println(savedProduct);
		
		savedProduct = productRepo.save(product3);
		System.out.println(savedProduct);
		
		savedProduct = productRepo.save(product4);
		
		context.close();
		
	}
}
