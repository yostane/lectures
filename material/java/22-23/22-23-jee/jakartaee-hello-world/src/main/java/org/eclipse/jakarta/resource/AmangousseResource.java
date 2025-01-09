package org.eclipse.jakarta.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jakarta.model.CrewMember;

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

@Path("/amangousse")
public class AmangousseResource {

    static List<CrewMember> crewMembers = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CrewMember> getAll() {
        return crewMembers;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(CrewMember crewMember) {
        crewMembers.add(crewMember);
        return Response.status(Status.CREATED).build();
    }

    @Path("{crewMemberName}")
    @DELETE
    public Response deleteByName(@PathParam("crewMemberName") String crewMemberName) {
        if (!crewMembers.stream().anyMatch((cm) -> cm.getName().equals(crewMemberName))) {
            return Response.status(Status.NOT_FOUND).build();
        }
        crewMembers = crewMembers.stream().filter((cm) -> !cm.getName().equals(crewMemberName)).toList();
        return Response.status(Status.OK).build();
    }
}
