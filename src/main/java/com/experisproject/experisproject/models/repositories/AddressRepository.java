package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "SELECT p.addressId ,CONCAT(p.addressLine1,',',p.addressLine2,',',p.addressLine3,',',p.postalCode,',',p.city,',',p.country) FROM Address p")
    List<Address> findAllShortInfo();

}
