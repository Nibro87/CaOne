package dtos;

import entities.Address;
import entities.Hobby;
import entities.Person;
import entities.Phone;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    String email;
    String firstName;
    String lastName;
    private List<PhoneDTO> phones;
    private List<HobbyDTO> hobby;
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

    public PersonDTO(String email, String firstName, String lastName, List<PhoneDTO> phone, List<HobbyDTO> hobby) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phone;
        this.hobby = hobby;
    }

    public PersonDTO(String email, String firstName, String lastName, List<PhoneDTO> phones) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
    }

    public void addPhone(PhoneDTO phoneDTO) {
        if(this.phones == null){
            ArrayList<PhoneDTO> phones = new ArrayList<>();
            phones.add(phoneDTO);
            this.phones = phones;
        }else {
            this.phones.add(phoneDTO);
        }
    }

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

    public List<PhoneDTO> getPhone() {
        return phones;
    }

    public void setPhone(List<PhoneDTO> phone) {
        this.phones = phone;
    }

    public List<HobbyDTO> getHobby() {
        return hobby;
    }

    public void setHobby(List<HobbyDTO> hobby) {
        this.hobby = hobby;
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
                ", hobby=" + hobby +
                ", address=" + address +
                '}';
    }
}
