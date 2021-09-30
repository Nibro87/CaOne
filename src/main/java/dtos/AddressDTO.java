package dtos;

import entities.Address;
import entities.Person;

import java.util.List;

public class AddressDTO {


    private String street;
    private String additionalInfo;
    List<PersonDTO> personDTOS;
    CityInfoDTO cityInfoDTO;




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

    public AddressDTO(String street, String additionalInfo, CityInfoDTO cityInfoDTO) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.cityInfoDTO = cityInfoDTO;
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

    @Override
    public String toString() {
        return "AddressDTO{" +
                "street='" + street + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", personDTOS=" + personDTOS +
                ", cityInfoDTO=" + cityInfoDTO +
                '}';
    }
}
