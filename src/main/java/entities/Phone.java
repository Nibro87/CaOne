package entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Phone implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id


    private String number;
    private String description;


    @ManyToOne Person person;

    public Phone() {
    }

    public Phone(String number, String description) {
        this.number = number;
        this.description = description;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
