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
import entities.Address;

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

        CityInfoDTO a = addressFacade.findCityByZipcode("0877");

        AddressDTO addressDTO = new AddressDTO("hvidovrevej","0877",a);

        System.out.println(addressDTO);

        addressFacade.createAddress(addressDTO);

























    }
    
    public static void main(String[] args) {
        populate();
    }




}
