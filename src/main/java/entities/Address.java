package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Address {

    private static final long serialVersionUID = 1L;
    @Id

    private String street;
    private String additionalInfo;

    @OneToMany(mappedBy = "Address",  cascade = CascadeType.PERSIST)
    List<Person> persons;

    @ManyToOne
    CityInfo cityInfo;


    public Address() {
    }

    public Address(String street, String additionalInfo, CityInfo cityInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;

        this.cityInfo = cityInfo;
    }

    public Address(String street, String additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;

    }

    public void addPerson(Person person){

        if(this.persons == null){
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(person);
            this.persons = persons;

        }else{
            this.persons.add(person);
        }



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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getStreet().equals(address.getStreet()) && getAdditionalInfo().equals(address.getAdditionalInfo()) && getPersons().equals(address.getPersons()) && getCityInfo().equals(address.getCityInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getAdditionalInfo(), getPersons(), getCityInfo());
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", persons=" + persons +
                ", cityInfo=" + cityInfo +
                '}';
    }
}
