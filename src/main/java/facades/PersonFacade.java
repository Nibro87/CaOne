package facades;

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

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }









    @Override
    public Person createPerson(String email, String firstName, String lastName) {
        Person person = new Person(email,firstName,lastName);
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


    @Override
    public List<PersonDTO> findByHobby(HobbyDTO hobbyDTO) {
        return null;
    }

    @Override
    public List<PersonDTO> findByZipCode(String Zipcode) {
        return null;
    }

    @Override
    public List<CityInfo> getAllZipCodes(){

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<CityInfo> query = em.createQuery("SELECT C.zipCode from CityInfo C",CityInfo.class);
            return query.getResultList();
        }finally {
            em.close();
        }





    }




}
