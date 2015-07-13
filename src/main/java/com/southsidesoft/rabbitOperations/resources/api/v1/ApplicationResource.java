package com.southsidesoft.rabbitOperations.resources.api.v1;

import com.southsidesoft.rabbitOperations.core.Application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/api/v1/application")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {
    @GET
    public ArrayList<Application> get(){
        ArrayList<Application> list = new ArrayList<Application>();
        list.add(new Application("one", "one"));
        list.add(new Application("two", "two"));

        return list;
    }

    @Path("/{id}")
    @GET
    public Application getById(@PathParam("id") int id){
        return new Application("one", String.format("%s_%d", "Tom", id));
    }

}
