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

    public AddressDTO createAddress(AddressDTO addressDTO) {

        Address address = new Address(addressDTO.getStreet(), addressDTO.getAdditionalInfo());

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
            return new AddressDTO(address);
        } finally {
            em.close();
        }
    }


    public CityInfoDTO findCityByZipcode(String zipcode){

        CityInfo cityInfo = null;

        EntityManager em = emf.createEntityManager();

        Query c2 = em.createQuery("SELECT c FROM CityInfo c WHERE c.zipCode =:zipcode").setParameter("zipcode",zipcode);
         cityInfo = (CityInfo) c2.getSingleResult();

        return new CityInfoDTO(String.valueOf(cityInfo));
    }






    }




