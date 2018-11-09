package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	@Query(value = "SELECT c.contactId, c.contactType, c.contactDetail, c.person.personId, CONCAT(c.person.firstName,' ', c.person.lastName) FROM Contact c")
	List<Contact> findContactsIdTypeDetailAndName();

	@Query(value = "SELECT c.contactId, c.contactType, c.contactDetail FROM Contact c WHERE c.person.personId = :personId")
	List<Contact> findContactByPersonId(@Param("personId") int personId);
}
