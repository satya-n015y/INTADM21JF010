package com.cognizant.contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.contacts.entity.Contact;
import com.cognizant.contacts.service.ContactService;

@SpringBootApplication
public class Application {
	private static ContactService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		LOGGER.info("--- inside main method ---");
		/*
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		
		Contact contact = new Contact();			
		contact.setContactName("Sunil Joseph");
		contact.setContactEmail("sunil@gmail.com");
		
		
		Contact contact1 = new Contact("Sanjay","a@hotmail.com");
		Contact contact2 = new Contact("Praveen","b@hotmail.com");
		Contact contact3 = new Contact("Naveen","c@hotmail.com");
		Contact contact4 = new Contact("Pankaj","d@hotmail.com");
		
		Iterable<Contact> contacts = Arrays.asList(contact, contact1, contact2, contact3, contact4);
		
		contactRepo.saveAll(contacts);
		*/
		
		service = context.getBean(ContactService.class);
		contactSaveMethod();	
		
		LOGGER.info("--- main method completes ---");
		/* --- context.close(); ---*/
	}
	
	private static void contactSaveMethod() {
		LOGGER.info("$$$ contactSave Method started $$$$ ---");
		Contact c = new Contact("Sravani", "sravani@gmail.com");		
		service.saveContact(c);
		LOGGER.info("*** New Contact Saved $$$$ ***");
		LOGGER.info("$$$ contactSave Method ended $$$$ ---");
	}
}
