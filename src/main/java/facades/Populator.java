/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dtos.*;
import entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class Populator {


    public static void populate(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        PersonFacade personFacade = new PersonFacade();
        AddressFacade addressFacade = new AddressFacade();
        HobbyFacade hobbyFacade = new HobbyFacade();
        ///CityInfoDTO a = addressFacade.findCityByZipcode("0877");

        ///AddressDTO addressDTO = new AddressDTO("hvidovrevej","0877",a);

        ///System.out.println(addressDTO);

        ///addressFacade.createAddress(addressDTO);





        Person person = new Person("email","firstname","lastname",null, null, null);
        Address address = new Address("hvidovrevej","0555",null);

        CityInfo cityInfo =addressFacade.findCityByZipcode("0555");

        cityInfo.addAddress(address);
        address.setCityInfo(cityInfo);

        Hobby hobby = hobbyFacade.findByName("Airsoft");

//        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone("1234","hej");

        address.addPerson(person);
        addressFacade.createAddress(address);
        person.setAddress(address);
        phone.setPerson(person);
        hobby.addPerson(person);
        //        phones.add(phone);

        person.addHobby(hobby);
        person.addPhone(phone);
        personFacade.createPerson(person);

        System.out.println(personFacade.findById(2L).getAddress().getPersons().get(0));





















    }
    
    public static void main(String[] args) {
        populate();
    }




}
