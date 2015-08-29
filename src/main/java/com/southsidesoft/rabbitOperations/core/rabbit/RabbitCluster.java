package com.southsidesoft.rabbitOperations.core.rabbit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.southsidesoft.rabbitOperations.core.Cluster;
import static jersey.repackaged.com.google.common.base.Preconditions.checkArgument;
import static org.eclipse.jetty.util.StringUtil.isNotBlank;

public class RabbitCluster implements Cluster {
    protected RabbitCluster(){
        //serialization
    }

    public RabbitCluster(String name, RabbitConnectionString rabbitConnectionString){
        checkArgument(isNotBlank(name), "%s cannot be null or empty", name);
        checkArgument(rabbitConnectionString != null, "rabbitConnectionString must be supplied");

        this.name = name;
        this.rabbitConnectionString = rabbitConnectionString;
    }

    private String name;
    private RabbitConnectionString rabbitConnectionString;

    @JsonProperty
    public RabbitConnectionString getRabbitConnectionString() {
        return rabbitConnectionString;
    }

    @JsonProperty
    public void setRabbitConnectionString(RabbitConnectionString rabbitConnectionString) {
        this.rabbitConnectionString = rabbitConnectionString;
    }

    @Override
    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @Override
    public String getConnectionString() {
        return rabbitConnectionString.toString();
    }
}
