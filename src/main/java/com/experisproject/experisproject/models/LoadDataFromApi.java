package com.experisproject.experisproject.models;

import com.experisproject.experisproject.models.entities.Address;
import com.experisproject.experisproject.models.entities.Location;
import com.experisproject.experisproject.services.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
public class LoadDataFromApi {
    private RestTemplate restTemplate;
    @Autowired
    public RestTemplate restTemplate(RestTemplate restTemplate){
        return this.restTemplate=restTemplate;
    }

    private int teamNumber=1;

    @Autowired
    TeamService teamService;
    @Autowired
    OwnerService ownerService;
    @Autowired
    LocationService locationService;
    @Autowired
    CoachService coachService;
    @Autowired
    PersonService personService;
    @Autowired
    AddressService addressService;
    @Autowired
    AssociationService associationService;
    @Autowired
    PlayerService playerService;

    @Scheduled(cron = "*/10 * * * * *")
    public void getData() throws IOException {
        System.out.println("Sending request");
        String url = "http://api.football-data.org/v2/teams/"+teamNumber;

        String key = "f3cb0631432944ba973ff3214dfbcb83";
        HttpHeaders header = new HttpHeaders();
        header.add("X-Auth-Token",key);
        HttpEntity<String> request = new HttpEntity<String>("parameters",header);
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,request, String.class);
        TeamData team = new ObjectMapper().readValue(response.getBody(),TeamData.class);


        key = "96deffbb5ec69d";
        url = "https://eu1.locationiq.com/v1/search.php?key="+key+"&q="+team.getVenue()+"&format=json&addressdetails=1&limit=1";
        HttpEntity<String> addressResponse = restTemplate.exchange(url, HttpMethod.GET,null, String.class);
        LocationData[] locationData = new ObjectMapper().readValue(addressResponse.getBody(),LocationData[].class);
        Address locationAddress = new Address(locationData[0].getAddress().getRoad(),locationData[0].getAddress().getHouse_number(),"",locationData[0].getAddress().getCity(),locationData[0].getAddress().getPostcode(),locationData[0].getAddress().getCountry());

        try{
            addressService.save(locationAddress);
            System.out.println("Valid venue");
        }catch (org.springframework.transaction.TransactionSystemException e){
            System.out.println("Not valid venue");
        }

        Location venue = new Location("Venue",null,locationAddress);

        for(PlayerData player:team.getSquad()){
            if(player.getRole().equals("COACH")){
                System.out.println("Coach");
            }
        }





        teamNumber++;

    }

}
@JsonIgnoreProperties(ignoreUnknown = true)
class TeamData implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    private String name;
    private String venue;

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<PlayerData> getSquad() {
        return squad;
    }

    public void setSquad(List<PlayerData> squad) {
        this.squad = squad;
    }

    private List<PlayerData> squad;
    private Area area;

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();

        out.append("Team: "+ name);
        out.append("\n");
        out.append("Address: "+ venue);

        for(PlayerData player:squad){
            out.append("\n");
            out.append(player);
        }



        return out.toString();
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class  PlayerData implements Serializable{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(String shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String name;
    private String position;
    private String dateOfBirth;
    private String nationality;
    private String shirtNumber;
    private String role;

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Name: ");
        out.append(name);
        out.append(" Position: ");
        out.append(position);
        out.append(" DateOfBirth: ");
        out.append(dateOfBirth);
        out.append(" Nationality: ");
        out.append(nationality);
        out.append(" ShirtNumber: ");
        out.append(shirtNumber);
        out.append(" Role: ");
        out.append(role);
        return out.toString();
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Area{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
@JsonIgnoreProperties(ignoreUnknown = true)
class LocationData implements Serializable{
    public AddressData getAddress() {
        return address;
    }

    public void setAddress(AddressData address) {
        this.address = address;
    }

    private AddressData address;
}
@JsonIgnoreProperties(ignoreUnknown = true)
class AddressData implements Serializable{
    @JsonAlias({"city","town"})
    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    private String postcode;
    @JsonAlias({"name"})
    private String road;
    private String house_number;

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        out.append("Country: ");
        out.append(country);
        out.append(" City: ");
        out.append(city);
        out.append(" PostalCode: ");
        out.append(country);

        return out.toString();
    }
}
