package com.cognizant.contacts.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.contacts.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Serializable> {

}
