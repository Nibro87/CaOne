package facades;

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




}
