package facades;

import dtos.CityInfoDTO;
import dtos.PersonDTO;
import entities.*;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade personFacade;
    private static AddressFacade addressFacade;
    private static HobbyFacade hobbyFacade;
    CityInfo cityInfo;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       personFacade = PersonFacade.getPersonFacade(emf);
       addressFacade = AddressFacade.getAddressFacade(emf);
       hobbyFacade = HobbyFacade.getHobbyFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() throws Exception {
        System.out.println("this test ran");
        PersonFacade personFacade = new PersonFacade();
        PersonDTO personDTO = new PersonDTO();



    }

    @Test
    public void testgetAllZipcodes(){
        List<CityInfoDTO> expected = personFacade.getAllZipCodes();
        int actual = 1352;

        assertEquals(expected.size(),actual);

    }

    @Test
    public void findByZipCode(){

        CityInfo actual =addressFacade.findCityByZipcode("0555");
        CityInfo expected = new CityInfo("0555","Scanning");
        assertEquals(expected,actual);


    }

    @Test
    public void findHobbyByName(){

        Hobby actual = hobbyFacade.findByName("Airsoft");
        Hobby expected = new Hobby("Airsoft","https://en.wikipedia.org/wiki/Airsoft","General"," Konkurrence");
        assertEquals(expected,actual);



    }



    @Test
    public void createPerson(){



    }




}
