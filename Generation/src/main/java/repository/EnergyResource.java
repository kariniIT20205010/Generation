package repository;
import model.Energy;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Energy")
public class EnergyResource {
    EnergyRepo repo =new EnergyRepo();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Energy> getEnergy(){

        System.out.println("details of Energy in our country");

        return repo.getEnergy();

    }

    // post method
    @POST
    @Path("Energy")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Energy createEnergy(Energy eng){
        repo.insertEnergy(eng);
        return eng;
    }

    //post method
    @PUT
    @Path("Energy")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Energy updateEnergy(Energy eng){
        repo.updateEnergy(eng);
        return eng;
    }

    //delete method
    @DELETE
    @Path("Energy/{Id}")
    public Energy killEnergy(@PathParam("Id") int Id){
        Energy eng = new Energy();

        if(Energy.getId()!=0)
            repo.deleteEnergy(Id);
        return eng;
    }

}
