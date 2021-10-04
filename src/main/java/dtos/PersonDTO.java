package dtos;

import entities.Address;
import entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    String email;
    String firstName;
    String lastName;
    private List<String> phones;
    private List<String> hobbies;
    Address address;


    public PersonDTO() {
    }

    public PersonDTO(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public PersonDTO(Person person) {

        this.email = person.getEmail();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();


    }

    public PersonDTO(String email, String firstName, String lastName, List<PhoneDTO> phones, List<HobbyDTO> hobbies) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
       for (PhoneDTO phoneDTO : phones){
           this.phones.add(phoneDTO.getNumber());
       }
        for(HobbyDTO hobbyDTO : hobbies){
            this.hobbies.add(hobbyDTO.getName());
        }

    }





    /*public void addPhone(PhoneDTO phoneDTO) {
        if(this.phones == null){
            ArrayList<PhoneDTO> phones = new ArrayList<>();
            phones.add(phoneDTO);
            this.phones = phones;
        }else {
            this.phones.add(phoneDTO);
        }
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phones +
                ", hobby=" + hobbies +
                ", address=" + address +
                '}';
    }
}
