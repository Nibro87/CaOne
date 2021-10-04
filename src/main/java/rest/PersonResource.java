package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CityInfoDTO;

import entities.Person;
import facades.AddressFacade;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private final PersonFacade FACADE = PersonFacade.getPersonFacade(EMF);
    private final AddressFacade addressFacade = AddressFacade.getAddressFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String person(){
        return "{\"msg\":\"Hello World\"}";
    }


    @GET
    @Path("zipcode/{zipcode}")
    @Produces("application/json")
    public Response FindAllPersonsInGivenZipcode(@PathParam("zipcode") String zipcode){
        List<Person> addressList = (List<Person>) addressFacade.findCityByZipcode(zipcode);

    }





    @GET
    @Path("/allZipcodes")
    @Produces("application/json")
    public String getAllZipcodes(){
        List<CityInfoDTO> cityInfo = FACADE.getAllZipCodes();
        return new Gson().toJson(cityInfo);
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addPerson(String person){

        Person person1 = GSON.fromJson(person,Person.class);
        person1 = FACADE.createPerson(person1);
        return Response.ok(GSON.toJson(person1),"application/json").build();


    }





}