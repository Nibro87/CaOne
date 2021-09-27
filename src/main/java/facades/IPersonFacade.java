package facades;


import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.CityInfo;
import entities.Person;

import java.util.List;

public interface IPersonFacade {



    Person createPerson(String email, String firstName, String lastName);

    /// get all persons by given hobby
       public List<PersonDTO> findByHobby(HobbyDTO hobbyDTO);

    /// get all persons living in a given zipcode
       public List<PersonDTO> findByZipCode(String Zipcode);


    List<CityInfo> getAllZipCodes();
}
