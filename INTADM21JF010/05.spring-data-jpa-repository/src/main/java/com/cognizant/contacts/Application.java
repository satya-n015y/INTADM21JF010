package com.cognizant.contacts;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cognizant.contacts.entity.Contact;
import com.cognizant.contacts.repository.ContactRepository;

@SpringBootApplication
public class Application {
	
	private static ContactRepository contactRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		contactRepo = context.getBean(ContactRepository.class);
		
		/*------------------------------------
		//to get contacts in the ascending order of contactName		
		List<Contact> contactsInOrder = contactRepo.findByOrderByContactNameAsc();
		contactsInOrder.forEach((contact)->{
			LOGGER.info(contact.toString());			
		});
		*/
		
		System.out.println("-------------------------------------");
		
		/*-----------------------------------
		List<Contact> contactsInOrderOfName = contactRepo.findAll(Sort.by("contactName").descending());
		
		contactsInOrderOfName.forEach((contact)->{
			LOGGER.info(contact.toString());			
		});
		*/		
		
		//retrieving records using Pagination
		int pageNo = 0 ; //pageNo starts from 0 (0 means first Page
		int pageSize = 6;
		Page<Contact> page1 = contactRepo.findAll(PageRequest.of(pageNo, pageSize));
		List<Contact> contacts = page1.getContent();
		
		contacts.forEach(contact -> LOGGER.info(contact.toString()));			
		System.out.println("--------------------------------");
		
		Contact sampleContact = new Contact();
		sampleContact.setContactName("Ajay");
		Example<Contact> exmpl = Example.of(sampleContact);
		List<Contact> matchingContacts = contactRepo.findAll(exmpl);
		matchingContacts.forEach(entity -> System.out.println(entity));
		context.close();
	}
}
