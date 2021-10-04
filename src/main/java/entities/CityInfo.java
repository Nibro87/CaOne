package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 4)
    private String zipCode;
    @Column(length=35)
    private String city;





    @OneToMany(mappedBy = "CityInfo", cascade = CascadeType.PERSIST)
    List<Address> addressList;


    public CityInfo() {
    }

    public CityInfo(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public void addAddress(Address address){
        if (this.addressList == null){
            ArrayList<Address> addressList = new ArrayList<>();
            addressList.add(address);
            this.addressList = addressList;
        }else{
            this.addressList.add(address);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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



    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", addressList=" + addressList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityInfo)) return false;
        CityInfo cityInfo = (CityInfo) o;
        return Objects.equals(getZipCode(), cityInfo.getZipCode()) && Objects.equals(getCity(), cityInfo.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZipCode(), getCity());
    }
}
