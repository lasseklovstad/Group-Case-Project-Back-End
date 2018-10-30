package com.experisproject.experisproject.models.repositories;

import com.experisproject.experisproject.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "SELECT p.addressId ,CONCAT(p.addressLine1,',',p.addressLine2,',',p.addressLine3,',',p.postalCode,',',p.city,',',p.country) FROM Address p")
    List<Address> findAddressesInfo();


    /*
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Address a SET address = :address WHERE addressId = a.addressId")
	int updateAddress(@Param("addressId") int addressId, @Param("address") String address);
*/
}
