package org.eclipse.jakarta.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jakarta.ejb.CrewBean;
import org.eclipse.jakarta.model.CrewMember;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/amangousse-ejb")
public class AmangousseResourceWithEJB {

    @Inject
    CrewBean crewBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CrewMember> getAll() {
        return crewBean.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(CrewMember crewMember) {
        crewBean.addOne(crewMember);
        return Response.status(Status.CREATED).build();
    }

    @Path("{crewMemberName}")
    @DELETE
    public Response deleteByName(@PathParam("crewMemberName") String crewMemberName) {
        return crewBean.deleteByName(crewMemberName)
                ? Response.status(Status.OK).build()
                : Response.status(Status.NOT_FOUND).build();
    }
}
