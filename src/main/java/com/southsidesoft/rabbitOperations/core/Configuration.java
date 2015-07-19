package com.southsidesoft.rabbitOperations.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Configuration {
    private ArrayList<Application> applications;
    private int databaseSchemaVersion;

    public Configuration(){
        applications = new ArrayList<>();
    }

    @JsonProperty
    public ArrayList<Application> getApplications() {
        return applications;
    }

    @JsonProperty
    public int getDatabaseSchemaVersion() {
        return databaseSchemaVersion;
    }
}
