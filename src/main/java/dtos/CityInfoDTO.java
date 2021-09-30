package dtos;

public class CityInfoDTO {

    private String zipCode;
    private String city;


    public CityInfoDTO() {
    }

    public CityInfoDTO(CityInfoDTO cityInfoDTO){

        this.zipCode = cityInfoDTO.getZipCode();
        this.city = cityInfoDTO.getCity();


    }

    public CityInfoDTO(String zipcode){
        this.zipCode = zipcode;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CityInfoDTO{" +
                "zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
