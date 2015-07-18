package com.southsidesoft.rabbitOperations.core;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestRabbitConnectionString {
    @Test
    public void should_return_basic_connection_string_when_no_options_set(){
        RabbitConnectionString obj = RabbitConnectionString.builder().build();

        assertThat(obj.toString()).isEqualTo("amqp://localhost");
    }

    @Test
    public void should_return_connection_string_with_logon_when_credentials_set(){
        RabbitConnectionString obj = RabbitConnectionString.builder()
                .setCredentials("user", "password")
                .build();

        assertThat(obj.toString()).isEqualTo("amqp://user:password@localhost");
    }

    @Test
    public void should_return_connection_string_with_vhost_when_vhost_set(){
        RabbitConnectionString obj = RabbitConnectionString.builder()
                .setVhost("vhost")
                .build();

        assertThat(obj.toString()).isEqualTo("amqp://localhost/vhost");
    }

    @Test
    public void should_return_connection_string_with_host_when_host_set(){
        RabbitConnectionString obj = RabbitConnectionString.builder()
                .setHost("host")
                .build();

        assertThat(obj.toString()).isEqualTo("amqp://host");
    }

    @Test
    public void should_return_connection_string_with_all_settings(){
        RabbitConnectionString obj = RabbitConnectionString.builder()
                .setHost("host")
                .setVhost("vhost")
                .setCredentials("user", "password")
                .build();

        assertThat(obj.toString()).isEqualTo("amqp://user:password@host/vhost");
    }
}
