package facades;

import dtos.*;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonFacade implements IPersonFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static PersonFacade instance;
    private Object CityInfo;

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }




    @Override
    public Person createPerson(Person person) {
        EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        return person;
    }finally {
        em.close();
    }
    }

    public Person findById(Long id){
        EntityManager em = emf.createEntityManager();
        return (em.find(Person.class, id));
    }




    @Override
    public List<PersonDTO> findPersonWithGivenHobby(HobbyDTO hobbyDTO) { return null; }








 ///get all persons living in a given city
    @Override
    public List<Person> findByZipCode(String zipCode) {

        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Person> query = em.createQuery("select a from Address a JOIN a.cityInfo c where c.zipCode =:zipcode", Person.class).setParameter("zipcode", zipCode);

            return query.getResultList();
        }finally {
            em.close();
        }
        }

    /// get all information about a person given a phonenumber
    @Override
    public List<Person> getByPhoneNumber(String number) {

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("select p from Person p JOIN p.phones c where c.number =:number", Person.class).setParameter("number", number);
            return query.getResultList();
        }finally {
            em.close();
        }
    }


    public List<Person> getByHobby(String name){

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p Join p.hobbies h where h.name =:name", Person.class).setParameter("name",name);
            return query.getResultList();

        }finally {
            em.close();
        }

    }





    /// get a list of all zipcodes in denmark
    @Override
    public List<CityInfoDTO> getAllZipCodes(){

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<CityInfoDTO> query = em.createQuery("SELECT C.zipCode from CityInfo C",CityInfoDTO.class);
            return query.getResultList();
        }finally {
            em.close();
        }





    }




}
