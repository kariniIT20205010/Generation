package resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("Source")
public class SourceResource {
    SourceRepo repo =new SourceRepo();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Source> getSource(){

        System.out.println("details of Source in our country");

        return repo.getSource();

    }

    // post method
    @POST
    @Path("Source")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Source createSource(Source soe){
        repo.insertSource(soe);
        return soe;
    }

    //post method
    @PUT
    @Path("Source")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Source updateSource(Source soe){
        repo.updateSource(soe);
        return soe;
    }

    //delete method
    @DELETE
    @Path("Source/{Id}")
    public Source killSource(@PathParam("Id") int Id){
        Source soe = new Source();

        if(soe.getId()!=0)
            repo.deleteSource(Id);
        return soe;
    }


}
