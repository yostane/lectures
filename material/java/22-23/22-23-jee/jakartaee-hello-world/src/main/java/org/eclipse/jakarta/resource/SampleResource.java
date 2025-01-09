package org.eclipse.jakarta.resource;

import org.eclipse.jakarta.model.TestModel;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/sample")
public class SampleResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/titans")
    public Response getTitans() {
        // src: https://attaque-des-titans.fandom.com/fr/wiki/Titans
        String titans[] = { "Titan Colossal", "Titan Cuirassé", "Titan Assaillant", "Titan Féminin", "Titan Mâchoire",
                "Titan Bestial",
                "Titan Charrette",
                "Titan Marteau d'Armes", "Titan Originel" };
        return Response.ok(titans).build();
    }

    // ! Ceci n'est pas trop conforme API-REST car du text/plain est renvoyé
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public Response testPost(TestModel testModel) {
        if (testModel.getName() == null) {
            return Response.status(403).build();
        }
        return Response.ok("Posted " + testModel.getName() + ". Age: " + testModel.getAge()).build();
    }
}
