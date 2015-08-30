package com.southsidesoft.rabbitOperations.resources.api.v1;

import com.southsidesoft.rabbitOperations.core.Cluster;
import com.southsidesoft.rabbitOperations.core.rabbit.RabbitCluster;
import com.southsidesoft.rabbitOperations.core.rabbit.RabbitConnectionString;
import static jersey.repackaged.com.google.common.base.Preconditions.checkArgument;
import static org.eclipse.jetty.util.StringUtil.isNotBlank;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/cluster")
@Produces(MediaType.APPLICATION_JSON)
public class ClusterResource {
    @Path("/{name}")
    @GET
    public Cluster getById(@PathParam("name") String name) {
        return new RabbitCluster(name, RabbitConnectionString.builder().build());
    }

    @PUT
    @Path("/{name}")
    public Cluster addOrEditCluster(@PathParam("name") String name, RabbitCluster cluster){
        checkArgument(isNotBlank(name));
        checkArgument(cluster != null);

        cluster.setName(name);

        //todo: save
        return cluster;
    }

}
