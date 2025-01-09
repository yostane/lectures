package com.cours.jee.rest;

import java.util.logging.Logger;

import com.cours.jee.model.Message;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/ping")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message ping() {
        Logger.getLogger("test").info("hello");
        return new Message("Rest API is running");
    }

}
