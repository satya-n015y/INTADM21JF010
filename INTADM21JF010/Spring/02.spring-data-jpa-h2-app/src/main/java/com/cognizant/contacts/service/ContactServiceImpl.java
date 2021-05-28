package com.cognizant.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.contacts.entity.Contact;
import com.cognizant.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepo;
	
	public void saveContact(Contact contact) {
		contactRepo.save(contact);
	}

}
