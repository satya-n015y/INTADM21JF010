package com.cognizant.contacts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.contacts.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{

	//public Contact findByContactEmail(String contactEmail);

	public Contact findByContactNameAndContactEmail(String name, String email);

	public Optional<Contact> findByContactEmail(String string);
	
	@Query(value = "select contactName from com.cognizant.contacts.entity.Contact")
	public List<String> findAllNames();
	
	@Query(value = "select contactName from com.cognizant.contacts.entity.Contact where contactEmail=:email ")
	public String findByNameForEmail(String email);
	
	@Query(value = "select contact_email from contacts", nativeQuery = true)
	public List<String> findContactEmails();
	
}
