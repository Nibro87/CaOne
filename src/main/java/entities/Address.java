package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {

    private static final long serialVersionUID = 1L;
    @Id

    private String street;
    private String additionalInfo;

    @OneToMany(mappedBy = "Address", cascade = CascadeType.PERSIST)
    List<Person> persons;

    @ManyToOne CityInfo cityInfo;


    public Address() {
    }

    public Address(String street, String additionalInfo, List<Person> persons, CityInfo cityInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.persons = persons;
        this.cityInfo = cityInfo;
    }

    public Address(String street, String additionalInfo, List<Person> persons) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.persons = persons;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }





    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }
}
