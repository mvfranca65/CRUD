package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	
	
}
