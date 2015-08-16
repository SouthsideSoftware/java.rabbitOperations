package com.southsidesoft.rabbitOperations.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaData {
    public MetaData(){
        //serialization
    }

    public MetaData(String version){
        this.version = version;
    }

    @JsonProperty
    public String getVersion() {
        return version;
    }

    private String version;
}
