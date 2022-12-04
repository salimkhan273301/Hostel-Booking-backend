package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contact;
import com.example.repository.ContactRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class ContactController {
	
private static final org.apache.logging.log4j.Logger logger =  LogManager.getLogger(EmployeeController.class);

 @Autowired()
private ContactRepository cr;
 // create Query rest API
	@PostMapping("/contacts")
	public Contact createQuery(@RequestBody Contact contact) {
		logger.info("Info log entered in create Query controller");
		System.out.println("Query is saved successfully");
		return cr.save(contact);
	}

}
