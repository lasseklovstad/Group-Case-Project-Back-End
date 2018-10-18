package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {
}
