package repository;
import model.Transformar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Transformar")
public class TransformarResource {
    TransformarRepo repo =new TransformarRepo();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Transformar> getTransformar(){

        System.out.println("details of Transformar in our country");

        return repo.getTransformar();

    }

    // post method
    @POST
    @Path("Transformar")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Transformar createTransformar(Transformar trf){
        repo.insertTransformar(trf);
        return trf;
    }

    //post method
    @PUT
    @Path("Transformar")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Transformar updateTransformar(Transformar trf){
        repo.updateTransformar(trf);
        return trf;
    }

    //delete method
    @DELETE
    @Path("Transformar/{Id}")
    public Transformar killTransformar(@PathParam("Id") int Id){
        Transformar trf = new Transformar();

        if(trf.getId()!=0)
            repo.deleteTransformar(Id);
        return trf;
    }

}
