package entities;

import dtos.PhoneDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String email;
    String firstName;
    String lastName;

    @OneToMany(mappedBy = "Person",  cascade = CascadeType.PERSIST)
    private List<Phone> phones;

    @ManyToMany
    private List<Hobby> hobbies;

    @ManyToOne
    Address address;



    public Person() {
    }

    public Person(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Person(String email, String firstName, String lastName, List<Phone> phones, List<Hobby> hobbies, Address address) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
        this.hobbies = hobbies;
        this.address = address;
    }

    public Person(Person person){
        this.email = person.getEmail();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.phones = person.getPhones();
        this.phones = person.getPhones();
        this.hobbies = person.getHobbies();
        this.address = person.getAddress();
    }

    public Person(long id) {
        this.id = id;
    }


    public void addPhone(Phone phone) {
        if(this.phones == null){
            ArrayList<Phone> phones = new ArrayList<>();
            phones.add(phone);
            this.phones = phones;
        }else {
            this.phones.add(phone);
        }
    }

    public void addHobby(Hobby hobby){
        if(this.hobbies == null){
            ArrayList<Hobby> hobbies = new ArrayList<>();
            hobbies.add(hobby);
            this.hobbies = hobbies;
        }else{
            this.hobbies.add(hobby);
        }

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
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
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phones=" + phones +
                ", hobbies=" + hobbies +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getEmail(), person.getEmail()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getPhones(), person.getPhones()) && Objects.equals(hobbies, person.hobbies) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getFirstName(), getLastName(), getPhones(), hobbies, address);
    }
}
