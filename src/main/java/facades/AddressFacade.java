package facades;

import dtos.AddressDTO;
import dtos.CityInfoDTO;
import dtos.PersonDTO;
import entities.Address;
import entities.CityInfo;
import entities.Person;

import javax.persistence.*;

public class AddressFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static AddressFacade instance;

    public AddressFacade() {
    }

    public static AddressFacade getAddressFacade(EntityManagerFactory _emf){

        if(instance == null){
            emf = _emf;
            instance = new AddressFacade();



        }

        return instance;
    }

    public Address createAddress(Address address) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
            return address;
        } finally {
            em.close();
        }
    }


    public CityInfo findCityByZipcode(String zipcode){

        EntityManager em = emf.createEntityManager();

        TypedQuery<CityInfo> c2 = em.createQuery("SELECT c FROM CityInfo c WHERE c.zipCode =:zipcode",CityInfo.class).setParameter("zipcode",zipcode);
        CityInfo cityInfo = c2.getSingleResult();

        return cityInfo;
    }






    }




