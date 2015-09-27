package com.southsidesoft.rabbitOperations.core.rabbit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.southsidesoft.rabbitOperations.core.Cluster;

import java.io.IOException;

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

    @JsonIgnore
    public byte[] getAsJSONBytes() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(this) ;
    }

    @JsonIgnore
    public String getAsJSONString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this) ;
    }

    @JsonIgnore
    public static RabbitCluster fromJson(String jsonInput) throws IOException {
        checkArgument(isNotBlank(jsonInput));

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonInput, RabbitCluster.class);
    }
}
