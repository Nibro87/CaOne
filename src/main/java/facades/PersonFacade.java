package facades;

import dtos.CityInfoDTO;
import dtos.HobbyDTO;
import dtos.PersonDTO;
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
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = new Person(personDTO.getEmail(),personDTO.getFirstName(),personDTO.getLastName());
        EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        return new PersonDTO(person);
    }finally {
        em.close();
    }
    }


    @Override
    public List<PersonDTO> findByHobby(HobbyDTO hobbyDTO) {
        return null;
    }

    @Override
    public List<Person> findByZipCode(String zipCode) {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p JOIN p.address a where a.cityInfo =:zipcode",Person.class);
        query.setParameter("zipcode",CityInfo);
        List<Person> personList = query.getResultList();
        return personList;




    }








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
