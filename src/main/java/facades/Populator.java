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




        PersonDTO person = personFacade.findById(1L);




























    }
    
    public static void main(String[] args) {
        populate();
    }




}
