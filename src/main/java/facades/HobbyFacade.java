package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class HobbyFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static HobbyFacade instance;


    public static HobbyFacade getHobbyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    public HobbyDTO findByName(String name){

        EntityManager em = emf.createEntityManager();

        TypedQuery<String> h2 = em.createQuery("SELECT h FROM Hobby h WHERE h.name =?1",String.class).setParameter(name,1);
        String hobby = h2.getSingleResult();


        return new HobbyDTO(hobby);
    }






}
