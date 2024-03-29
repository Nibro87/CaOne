package entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Hobby {

    private static final long serialVersionUID = 1L;



    @Id
    @Column(length = 50)
    private String name;

    private String wikiLink;
    private String category;
    private String type;


    @ManyToMany
    private List<Person> persons;


    public Hobby() {
    }

    public Hobby(String name, String wikiLink, String category, String type) {
        this.name = name;
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
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

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {

        if(this.persons == null){
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(person);
            this.persons = persons;
        }else{
            this.persons.add(person);
        }





    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hobby)) return false;
        Hobby hobby = (Hobby) o;
        return Objects.equals(getName(), hobby.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                ", wikiLink='" + wikiLink + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", persons=" + persons +
                '}';
    }
}
