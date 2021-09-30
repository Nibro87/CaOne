package dtos;

import entities.Address;
import entities.Person;

public class AddressDTO {


    private String street;
    private String additionalInfo;


    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.additionalInfo = address.getAdditionalInfo();
    }

    public AddressDTO(String street, String additionalInfo) {

        this.street = street;
        this.additionalInfo = additionalInfo;

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
}
