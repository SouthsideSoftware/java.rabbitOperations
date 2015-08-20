package com.southsidesoft.rabbitOperations.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import static jersey.repackaged.com.google.common.base.Preconditions.checkArgument;
import static org.eclipse.jetty.util.StringUtil.isNotBlank;

public class MetaData {
    public MetaData(){
        //serialization
    }

    public MetaData(String version){
        checkArgument(isNotBlank(version), "%s cannot be null, empty or whitespace", version);

        this.version = version;
    }

    @JsonProperty
    public String getVersion() {
        return version;
    }

    private String version;
}
