package com.southsidesoft.rabbitOperations.resources.api.v1;

import com.southsidesoft.rabbitOperations.core.MetaData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api/v1/metaData")
@Produces(MediaType.APPLICATION_JSON)
public class MetaDataResource {
    @GET
    public MetaData get() {
        Package p = getClass().getPackage();
        String version = p.getImplementationVersion();
        if (version == null){
            version = "0.0.1-STUB";
        }
        return new MetaData(version);
    }
}

