package com.cognizant.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.contacts.entity.ContactsMasterEntity;
import com.cognizant.contacts.repository.ContactsMasterRepository;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		/*--- get the repository bean from IoC ---*/
		ContactsMasterRepository contactsMasterRepo = context.getBean(ContactsMasterRepository.class);
		System.out.println("$$$ "+ contactsMasterRepo.getClass().getName()+" $$$$"); //implementation class is being created internally 
		
		/*--- create an Entity Instance ---*/
		ContactsMasterEntity contactEntity = new ContactsMasterEntity();
		contactEntity.setContactId(104);
		contactEntity.setContactName("Vicky Singh");
		contactEntity.setContactNumber("1234567890");
		
		/*--- save the entity ---*/
		ContactsMasterEntity savedEntity = contactsMasterRepo.save(contactEntity); //Saves the given entity in the persistence store; returns the saved entity
		System.out.println(savedEntity); //toString()
		
		/*--- close the container ---*/
		context.close();
	}

}
