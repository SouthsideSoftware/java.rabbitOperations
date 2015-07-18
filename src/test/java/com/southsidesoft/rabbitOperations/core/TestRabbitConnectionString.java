package com.southsidesoft.rabbitOperations.core;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestRabbitConnectionString {
    @Test
    public void should_return_basic_connection_string_when_no_options_set(){
        RabbitConnectionString obj = new RabbitConnectionString();

        assertThat(obj.toString()).isEqualTo("amqp://localhost");
    }

    @Test
    public void should_return_connection_string_with_logon_when_credentials_set(){
        RabbitConnectionString obj = new RabbitConnectionString();

        obj.setCredentials("user", "password");

        assertThat(obj.toString()).isEqualTo("amqp://user:password@localhost");
    }

    @Test
    public void should_return_connection_string_with_vhost_when_vhost_set(){
        RabbitConnectionString obj = new RabbitConnectionString();

        obj.setVhost("vhost");

        assertThat(obj.toString()).isEqualTo("amqp://localhost/vhost");
    }

    @Test
    public void should_return_connection_string_with_host_when_host_set(){
        RabbitConnectionString obj = new RabbitConnectionString();

        obj.setHost("host");

        assertThat(obj.toString()).isEqualTo("amqp://host");
    }

    @Test
    public void should_return_connection_string_with_all_settings(){
        RabbitConnectionString obj = new RabbitConnectionString("host", "vhost", "user", "password");

        obj.setHost("host");

        assertThat(obj.toString()).isEqualTo("amqp://user:password@host/vhost");
    }
}
