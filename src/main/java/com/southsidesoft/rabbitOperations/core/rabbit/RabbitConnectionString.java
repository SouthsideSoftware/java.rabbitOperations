package com.southsidesoft.rabbitOperations.core.rabbit;

import com.fasterxml.jackson.annotation.JsonProperty;

import static jersey.repackaged.com.google.common.base.Preconditions.checkArgument;
import static org.eclipse.jetty.util.StringUtil.isNotBlank;


public class RabbitConnectionString {
    private String host;
    private String user;
    private String password;
    private String vhost;

    public static class Builder {
        private String host;
        private String user;
        private String password;
        private String vhost;

        public RabbitConnectionString build()
        {
            if (host == null){
                host = "localhost";
            }

            return new RabbitConnectionString(this);
        }

        public Builder setHost(String host) {
            checkArgument(isNotBlank(host), "%s cannot be null, empty or whitespace", host);

            this.host = host;
            return this;
        }

        public Builder setCredentials(String user, String password) {
            checkArgument(isNotBlank(user), "%s cannot be null, empty or whitespace", user);
            checkArgument(isNotBlank(password), "%s cannot be null, empty or whitespace", password);

            this.user = user;
            this.password = password;
            return this;
        }

        public Builder setVhost(String vhost) {
            checkArgument(isNotBlank(vhost), "%s cannot be null, empty or whitespace", vhost);

            this.vhost = vhost;
            return this;
        }
    }

    public static Builder builder(){
        return new Builder();
    }

    protected RabbitConnectionString() {
        //serialization
    }

    private RabbitConnectionString(Builder builder) {
        this.host = builder.host;
        this.user = builder.user;
        this.password = builder.password;
        this.vhost = builder.vhost;
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
