package com.southsidesoft.rabbitOperations.resources;

import com.southsidesoft.rabbitOperations.views.DashboardView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/")
@Produces({MediaType.TEXT_HTML})
public class DashboardResource {
    @GET
    public Response get(@Context HttpServletRequest request,
                        @Context HttpServletResponse response) throws Exception{
        return Response.seeOther(new URI("/web/index.html")).build();
    }
}
