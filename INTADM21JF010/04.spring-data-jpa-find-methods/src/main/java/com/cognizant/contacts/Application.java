package com.cognizant.contacts;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.contacts.repository.ContactRepository;

@SpringBootApplication
public class Application {
	
	private static ContactRepository contactRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		contactRepo = context.getBean(ContactRepository.class);
		
		/*-----------------------------------------
		Optional<Contact> contactOpt = contactRepo.findByContactEmail("sunil@cognizant.com");
		if(contactOpt.isPresent()) {
			LOGGER.info(contactOpt.get()+"");
		}else {
			LOGGER.error("### No matching Contact Found ###");
		}
		*/
		
		/*-----------------------------------------
		Contact contact = contactRepo.findByContactNameAndContactEmail("Ajay","sunil@gmail.com");
		if(contact != null)
			LOGGER.info(contact.toString());
		else
			LOGGER.error("### No Contact found with the provided keys ###");
		*/
		
		
		/*-------------------------------------
		List<String> contactNames = contactRepo.findAllNames();
		for(String name : contactNames) {
			LOGGER.info(name);
			Thread.sleep(2000);
		}
		*/
		
		/*-------------------------------------
		String name = contactRepo.findByNameForEmail("ajay@gmail.com");
		LOGGER.info(name);
		*/
		
		List<String> contactEmails = contactRepo.findContactEmails();
		for(String email : contactEmails) {
			LOGGER.info(email);
			Thread.sleep(2000);
		}
		context.close();
	}
}
