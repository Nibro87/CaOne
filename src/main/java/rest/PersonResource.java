package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CityInfoDTO;

import entities.CityInfo;
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
    public Response getServerIsUp(){
        return Response.ok(GSON.toJson("hello"),MediaType.APPLICATION_JSON).build();
    }


    @GET
    @Path("zipcode/{zipcode}")
    @Produces("application/json")
    public Response FindAllPersonsInGivenZipcode(@PathParam("zipcode") String zipcode){


        return null;
    }





    @GET
    @Path("/allZipcodes")
    @Produces("application/json")
    public Response getAllZipcodes(){

        return Response.ok(GSON.toJson(FACADE.getAllZipCodes()),"application/json").build();
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addPerson(String person){

        Person person1 = GSON.fromJson(person,Person.class);
        person1 = FACADE.createPerson(person1);
        return Response.ok(GSON.toJson(person1),"application/json").build();


    }


    @GET
    @Path("{id}")
    @Produces("application/json")
public Response getpersonById(@PathParam("id")long id){
        Person person = FACADE.findById(id);
        return Response.ok(GSON.toJson(person),"application/json").build();
    }

    @GET
    @Path("hobby/{hobby}")
    @Produces("application/json")
    public Response getAllPersonsGivenAHobby(@PathParam("hobby") String hobby){
        List<Person> personList = FACADE.getByHobby(hobby);
        return Response.ok(GSON.toJson(hobby),"application/json").build();
    }


}