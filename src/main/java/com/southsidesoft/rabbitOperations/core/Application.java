package com.southsidesoft.rabbitOperations.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application {
    private String name;
    private String id;
    private String auditQueue;
    private String errorQueue;
    private int maxMessagePerRun;
    private int pollingTimeoutMilliseconds;
    private int heartbeatIntervalSeconds;
    private boolean autoStartQueuePolling;
    private int documentExpirationDays;
    private int rabbitManagementPort;
    private short prefetch;


    public Application() {
        //serialization
    }

    public Application(String id, String name) {
        this.id = id;
        this.name = name;
        auditQueue = "audit";
        errorQueue = "error";
        pollingTimeoutMilliseconds = 500;
        heartbeatIntervalSeconds = 10;
        autoStartQueuePolling = false;
        documentExpirationDays = 7*24;
        rabbitManagementPort = 15672;
        prefetch = 10;
    }

    @JsonProperty
    public int getPollingTimeoutMilliseconds() {
        return pollingTimeoutMilliseconds;
    }

    @JsonProperty
    public int getHeartbeatIntervalSeconds() {
        return heartbeatIntervalSeconds;
    }

    @JsonProperty
    public boolean isAutoStartQueuePolling() {
        return autoStartQueuePolling;
    }

    @JsonProperty
    public int getDocumentExpirationDays() {
        return documentExpirationDays;
    }

    @JsonProperty
    public int getRabbitManagementPort() {
        return rabbitManagementPort;
    }

    @JsonProperty
    public short getPrefetch() {
        return prefetch;
    }

    @JsonProperty
    public int getMaxMessagePerRun() {
        return maxMessagePerRun;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getAuditQueue() {
        return auditQueue;
    }

    @JsonProperty
    public String getErrorQueue() {
        return errorQueue;
    }
}
