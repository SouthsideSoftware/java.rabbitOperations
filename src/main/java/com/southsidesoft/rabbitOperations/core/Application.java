package com.southsidesoft.rabbitOperations.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.southsidesoft.rabbitOperations.core.rabbit.RabbitConnectionString;

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
    private Cluster cluster;


    protected Application() {
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
        documentExpirationDays = 7 * 24;
        rabbitManagementPort = 15672;
        prefetch = 10;
        maxMessagePerRun = 0;
        //for now, we hardcode a rabbit cluster
        cluster = (Cluster)RabbitConnectionString.builder().build();
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    protected void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    protected void setId(String id) {
        this.id = id;
    }

    @JsonProperty
    public String getAuditQueue() {
        return auditQueue;
    }

    @JsonProperty
    protected void setAuditQueue(String auditQueue) {
        this.auditQueue = auditQueue;
    }

    @JsonProperty
    public String getErrorQueue() {
        return errorQueue;
    }

    @JsonProperty
    protected void setErrorQueue(String errorQueue) {
        this.errorQueue = errorQueue;
    }

    @JsonProperty
    public int getMaxMessagePerRun() {
        return maxMessagePerRun;
    }

    @JsonProperty
    protected void setMaxMessagePerRun(int maxMessagePerRun) {
        this.maxMessagePerRun = maxMessagePerRun;
    }

    @JsonProperty
    public int getPollingTimeoutMilliseconds() {
        return pollingTimeoutMilliseconds;
    }

    @JsonProperty
    protected void setPollingTimeoutMilliseconds(int pollingTimeoutMilliseconds) {
        this.pollingTimeoutMilliseconds = pollingTimeoutMilliseconds;
    }

    @JsonProperty
    public int getHeartbeatIntervalSeconds() {
        return heartbeatIntervalSeconds;
    }

    @JsonProperty
    protected void setHeartbeatIntervalSeconds(int heartbeatIntervalSeconds) {
        this.heartbeatIntervalSeconds = heartbeatIntervalSeconds;
    }

    @JsonProperty
    public boolean isAutoStartQueuePolling() {
        return autoStartQueuePolling;
    }

    @JsonProperty
    protected void setAutoStartQueuePolling(boolean autoStartQueuePolling) {
        this.autoStartQueuePolling = autoStartQueuePolling;
    }

    @JsonProperty
    public int getDocumentExpirationDays() {
        return documentExpirationDays;
    }

    @JsonProperty
    protected void setDocumentExpirationDays(int documentExpirationDays) {
        this.documentExpirationDays = documentExpirationDays;
    }

    @JsonProperty
    public int getRabbitManagementPort() {
        return rabbitManagementPort;
    }

    @JsonProperty
    public void setRabbitManagementPort(int rabbitManagementPort) {
        this.rabbitManagementPort = rabbitManagementPort;
    }

    @JsonProperty
    public short getPrefetch() {
        return prefetch;
    }

    @JsonProperty
    public void setPrefetch(short prefetch) {
        this.prefetch = prefetch;
    }

    @JsonProperty
    public Cluster getCluster() {
        return cluster;
    }

    @JsonProperty
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
}
