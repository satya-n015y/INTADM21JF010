package com.cognizant.contacts.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.contacts.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Serializable> {

}
