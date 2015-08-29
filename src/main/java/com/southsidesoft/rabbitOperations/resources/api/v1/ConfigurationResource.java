package com.southsidesoft.rabbitOperations.resources.api.v1;

import com.southsidesoft.rabbitOperations.core.Configuration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/configuration")
@Produces(MediaType.APPLICATION_JSON)
public class ConfigurationResource {
    @Path("/{id}")
    @GET
    public Configuration getById(@PathParam("id") int id) {
        return new Configuration();
    }

}
