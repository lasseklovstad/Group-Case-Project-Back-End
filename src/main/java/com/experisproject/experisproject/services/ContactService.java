package com.experisproject.experisproject.services;

import com.experisproject.experisproject.models.entities.Contact;
import com.experisproject.experisproject.models.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

	private ContactRepository contactRepository;

	@Autowired
	public ContactRepository contactRepository(ContactRepository contactRepository){
		return this.contactRepository = contactRepository;
	}

	public List<Contact> findContactsIdTypeDetailAndName(){
		return contactRepository.findContactsIdTypeDetailAndName();
	}

	public Contact findById(int id){
		return contactRepository.findById(id).get();
	}

	public List<Contact> findContactByPersonId(int personId){
		return contactRepository.findContactByPersonId(personId);
	}

	public List<Contact> findAll(){
		return contactRepository.findAll();
	}

	public void updateContact(Contact contact){
		save(contact);
	}

	public void save(Contact contact){
		contactRepository.save(contact);
	}

	public void deleteById(int id){
		contactRepository.deleteById(id);
	}


}
