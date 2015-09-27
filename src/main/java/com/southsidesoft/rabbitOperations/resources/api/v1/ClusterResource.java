package com.southsidesoft.rabbitOperations.resources.api.v1;

import com.southsidesoft.rabbitOperations.core.Cluster;
import com.southsidesoft.rabbitOperations.core.rabbit.RabbitCluster;
import com.southsidesoft.rabbitOperations.core.rabbit.RabbitConnectionString;
import static jersey.repackaged.com.google.common.base.Preconditions.checkArgument;
import static org.eclipse.jetty.util.StringUtil.isNotBlank;
import io.dropwizard.elasticsearch.managed.ManagedEsClient;
import org.elasticsearch.client.Client;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Path("/api/v1/cluster")
@Produces(MediaType.APPLICATION_JSON)
public class ClusterResource {
    private ManagedEsClient managedEsClient;
    public static final String INDEX = "cluster";
    public static final String DOC_TYPE = "rabbitCluster";

    public ClusterResource(ManagedEsClient managedEsClient){
        checkArgument(managedEsClient != null);

        this.managedEsClient = managedEsClient;
    }

    @Path("/{name}")
    @GET
    public Cluster getById(@PathParam("name") String name) {
        return new RabbitCluster(name, RabbitConnectionString.builder().build());
    }

    @PUT
    @Path("/")
    public Cluster addOrEditCluster(RabbitCluster cluster) throws InterruptedException, ExecutionException, IOException {
        checkArgument(cluster != null);
        checkArgument(isNotBlank(cluster.getName()));

        Client client = managedEsClient.getClient();
        client.prepareIndex(INDEX, DOC_TYPE, cluster.getName()).setSource(cluster.getAsJSONBytes()).execute();
        return cluster;
    }

    @DELETE
    @Path("/{name}")
    public void deleteCluster(@PathParam("name") String name) {
        checkArgument(isNotBlank(name));

        Client client = managedEsClient.getClient();
        client.prepareDelete(INDEX, DOC_TYPE, name).execute();
    }

}
