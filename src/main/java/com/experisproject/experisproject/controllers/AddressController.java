package com.experisproject.experisproject.controllers;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Address> findAllShortInfo(){
        return addressService.getAllShortInfo();
    }
}
