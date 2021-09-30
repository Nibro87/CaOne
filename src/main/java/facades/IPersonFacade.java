package facades;


import dtos.*;
import entities.Person;
import entities.Phone;

import java.util.List;

public interface IPersonFacade {



    /// create a person
    PersonDTO createPerson(PersonDTO personDTO);

    /// get all persons by given hobby
       public List<PersonDTO> findByHobby(HobbyDTO hobbyDTO);

    /// get all persons living in a given zipcode
       public List<Person> findByZipCode(String Zipcode);


       /// get a persons information by phoneNumber
    public List<Person> getByPhoneNumber(String Number);


    ///find all zipcodes
    List<CityInfoDTO> getAllZipCodes();
}
