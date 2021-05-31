package com.cognizant.contacts;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.contacts.entity.Contact;
import com.cognizant.contacts.repository.ContactRepository;
import com.cognizant.contacts.service.ContactService;

@SpringBootApplication
public class Application {
	private static ContactService service;
	private static ContactRepository  contactRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		LOGGER.info("--- inside main method ---");
		
		service = context.getBean(ContactService.class);
		//contactSavemethod();
		contactRepo = context.getBean(ContactRepository.class);
		
		
		// to save multiple contacts ---
		/*
		Contact contact_1 = new Contact("Praveen", "praveen@gmail.com");
		Contact contact_2 = new Contact("Ajay", "ajay@gmail.com");
		Contact contact_3 = new Contact("Pankaj", "pankaj@gmail.com");
		Contact contact_4 = new Contact("Sravya", "sravya@gmail.com");
		Contact contact_5 = new Contact("Srinivas", "srini@hotmail.com");
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact_1);
		contacts.add(contact_2);
		contacts.add(contact_3);
		contacts.add(contact_4);
		contacts.add(contact_5);
		*/
		List<Contact> contacts = new ArrayList<Contact>();
		for(int i=1;i<=50;i++) {
			Contact contact = new Contact("Contact-"+i, "contact"+i+"@gmail.com");
			contacts.add(contact);
		}
		Iterable<Contact> savedContacts = contactRepo.saveAll(contacts);
		
		for(Contact c : savedContacts) {
			LOGGER.info(c.toString());
			try {
				Thread.sleep(1000);
			}catch(Exception ex) {}
		}
		
		
		/*---------------------------------------------------------------
		//--to get an entity based on ID
		Optional<Contact> optContact = contactRepo.findById(18);
		if(optContact.isPresent()) {
			Contact contactFound = optContact.get();
			LOGGER.info(contactFound.getContactId()+" | "+ contactFound.getContactName()+" | "+contactFound.getContactEmail());
		}else {
			LOGGER.info("--- No Matching Contact Information Found! ---");
		}
		*/
		
		
		/*---------------------------------------------------------------
		//to get multiple entities based on ID and also to get all enties
		Iterable<Serializable> contactIds = Arrays.asList(1,2,3,4,5,25);
		
		//Iterable<Contact> searchedContacts = contactRepo.findAllById(contactIds);
		
		Iterable<Contact> searchedContacts = contactRepo.findAll();
		
		for(Contact c : searchedContacts) {
			LOGGER.info(c.toString());
			try {
				Thread.sleep(2000);
			}catch(Exception ex) {}
		}
		*/
		
		/*---------------------------------------------------------------
		//to check whether an entity is present in DB
		boolean entityStatus = contactRepo.existsById(12);
		LOGGER.info("--- Is Contact with ID \"12\" present = "+ entityStatus +" ---");
		*/		
		
		
		/*---------------------------------------------------------------
		//to get the count of entities in DB
		long noOfContacts = contactRepo.count();
		LOGGER.info("### No of Contacts = "+ noOfContacts + " ####");
		*/
		
		/*----------------------------------------
		// to update a contact
		Contact contactToUpdate = new Contact(1,"Sunil Joseph","sunil@cognizant.com");
		updateContact(contactToUpdate);
		*/
		LOGGER.info("--- main method completes ---");
		context.close(); 
	}
	
	private static void updateContact(Contact contactToUpdate) {
		LOGGER.debug("$$$ updateContact method started $$$$");
		
		contactRepo.save(contactToUpdate);
		
		LOGGER.info("@@@ Contact Updated @@@");
		LOGGER.debug("$$$ updateContact method completed $$$$");
	}

	private static void contactSaveMethod() {
		LOGGER.debug("$$$ contactSave Method started $$$$ ---");
		
		Contact c = new Contact("Sunil", "sunil@gmail.com");
		LOGGER.info("@@@ " + c + " @@@");
		
		Contact savedContact = service.saveContact(c);
		LOGGER.info("@@@ Saved Entity = " + savedContact + " @@@");		
		
		LOGGER.debug("$$$ contactSave Method ended $$$$ ---");
	}
}
