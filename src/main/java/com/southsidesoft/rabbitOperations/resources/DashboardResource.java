package com.southsidesoft.rabbitOperations.resources;

import com.southsidesoft.rabbitOperations.views.DashboardView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces({MediaType.TEXT_HTML})
public class DashboardResource {
    @GET
    public DashboardView get(){
        return new DashboardView();
    }
}
