package com.southsidesoft.rabbitOperations.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import static jersey.repackaged.com.google.common.base.Preconditions.checkArgument;
import static org.eclipse.jetty.util.StringUtil.isNotBlank;


public class RabbitConnectionString {
    private String host;
    private String user;
    private String password;
    private String vhost;

    public RabbitConnectionString() {


    }

    public RabbitConnectionString(String host, String vhost, String user, String password){
        checkArgument(isNotBlank(host), "%s cannot be null, empty or whitespace", host);
        checkArgument(isNotBlank(vhost), "%s cannot be null, empty or whitespace", vhost);
        checkArgument(isNotBlank(user), "%s cannot be null, empty or whitespace", user);
        checkArgument(isNotBlank(password), "%s cannot be null, empty or whitespace", password);

        this.host = host;
        this.vhost = vhost;
        this.user = user;
        this.password = password;

    }

    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public String getUser() {
        return user;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public String getVhost() {
        return vhost;
    }

    public void setHost(String host) {
        checkArgument(isNotBlank(host), "%s cannot be null, empty or whitespace", host);

        this.host = host;
    }

    public void setVhost(String vhost) {
        checkArgument(isNotBlank(vhost), "%s cannot be null, empty or whitespace", vhost);

        this.vhost = vhost;
    }

    public void setCredentials(String user, String password){
        checkArgument(isNotBlank(user), "%s cannot be null, empty or whitespace", user);
        checkArgument(isNotBlank(password), "%s cannot be null, empty or whitespace", password);

        this.user = user;
        this.password = password;
    }

    @Override
    public String toString(){
        String sCredentials = "";
        String sHost = "localhost";
        String sVhost = "";

        if (isNotBlank(user) && isNotBlank(password)) {
            sCredentials = user + ":" + password + "@";
        }
        if (isNotBlank(vhost)) {
            sVhost = "/" + vhost;
        }
        if (isNotBlank(host)) {
            sHost = host;
        }
        String connectionString = String.format("amqp://%s%s%s", sCredentials, sHost, sVhost);
        return connectionString;
    }
}
