package com.southsidesoft.rabbitOperations.core.rabbit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.southsidesoft.rabbitOperations.core.Cluster;

public class RabbitCluster implements Cluster {
    protected RabbitCluster(){
        //serialization
    }

    public RabbitCluster(String name, RabbitConnectionString rabbitConnectionString){

    }

    private String name;
    private RabbitConnectionString rabbitConnectionString;

    @JsonProperty
    public RabbitConnectionString getRabbitConnectionString() {
        return rabbitConnectionString;
    }

    @JsonProperty
    protected void setRabbitConnectionString(RabbitConnectionString rabbitConnectionString) {
        this.rabbitConnectionString = rabbitConnectionString;
    }

    @Override
    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    protected void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @Override
    public String getConnectionString() {
        return rabbitConnectionString.toString();
    }
}
