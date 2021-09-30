package facades;

import dtos.AddressDTO;
import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    public AddressDTO createAddress(AddressDTO addressDTO){

        Address address = new Address(addressDTO.getStreet(), addressDTO.getAdditionalInfo());

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
            return new AddressDTO(address);
        }finally {
            em.close();
        }
        





    }



}
