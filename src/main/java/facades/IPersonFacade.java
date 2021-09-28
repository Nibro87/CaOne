package facades;


import dtos.CityInfoDTO;
import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.Person;

import java.util.List;

public interface IPersonFacade {



    /// create a person
    PersonDTO createPerson(PersonDTO personDTO);

    /// get all persons by given hobby
       public List<PersonDTO> findByHobby(HobbyDTO hobbyDTO);

    /// get all persons living in a given zipcode
       public List<Person> findByZipCode(String Zipcode);

    ///find all zipcodes
    List<CityInfoDTO> getAllZipCodes();
}
