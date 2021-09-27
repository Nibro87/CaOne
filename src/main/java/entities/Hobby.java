package entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Hobby {

    private static final long serialVersionUID = 1L;
    @Id


    private String name;
    private String description;


    @ManyToMany
    private List<Person> persons;


    public Hobby() {
    }

    public Hobby(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Hobby(String name, String description, List<Person> persons) {
        this.name = name;
        this.description = description;
        this.persons = persons;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
