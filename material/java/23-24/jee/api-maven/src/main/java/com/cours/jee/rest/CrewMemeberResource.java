package com.cours.jee.rest;

import java.net.URI;
import java.util.List;

import com.cours.jee.ejb.CalculatorBean;
import com.cours.jee.ejb.CrewMemberBean;
import com.cours.jee.model.CalculatorResult;
import com.cours.jee.model.CrewMember;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/crew")
public class CrewMemeberResource {

  @Inject
  CrewMemberBean crewMemberBean;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<CrewMember> getAll() {
    return crewMemberBean.getAll();
  }

  @Path("/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public CrewMember getOne(@PathParam("id") String id) {
    return crewMemberBean.getOne(id);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response add(CrewMember crewMember) {
    try {
      crewMemberBean.add(crewMember);
      return Response.created(URI.create("/api/crew/" + crewMember.getId())).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST).build();
    }
  }
}
