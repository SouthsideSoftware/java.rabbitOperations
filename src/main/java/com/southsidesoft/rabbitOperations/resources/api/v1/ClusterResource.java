package com.southsidesoft.rabbitOperations.resources.api.v1;

import com.southsidesoft.rabbitOperations.core.Cluster;
import com.southsidesoft.rabbitOperations.core.Configuration;
import com.southsidesoft.rabbitOperations.core.rabbit.RabbitCluster;
import com.southsidesoft.rabbitOperations.core.rabbit.RabbitConnectionString;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/cluster")
@Produces(MediaType.APPLICATION_JSON)
public class ClusterResource {
    @Path("/{name}")
    @GET
    public Cluster getById(@PathParam("name") String name) {
        return new RabbitCluster(name, RabbitConnectionString.builder().build());
    }

}
