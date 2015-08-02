package com.southsidesoft.rabbitOperations;

import com.nefariouszhen.dropwizard.assets.ConfiguredAssetsBundle;
import com.southsidesoft.rabbitOperations.resources.DashboardResource;
import com.southsidesoft.rabbitOperations.resources.api.v1.ApplicationResource;
import com.southsidesoft.rabbitOperations.resources.api.v1.ConfigurationResource;
import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.southsidesoft.rabbitOperations.health.TemplateHealthCheck;
import io.dropwizard.views.ViewBundle;
import org.glassfish.jersey.server.ResourceConfig;
import org.secnod.dropwizard.shiro.ShiroBundle;
import org.secnod.dropwizard.shiro.ShiroConfiguration;

public class RabbitOperationsApplication extends Application<RabbitOperationsConfiguration> {
    public static void main(String[] args) throws Exception {
        new RabbitOperationsApplication().run(args);
    }

    @Override
    public String getName() {
        return "rabbitOperations";
    }

    @Override
    public void initialize(Bootstrap<RabbitOperationsConfiguration> bootstrap) {
        bootstrap.addBundle(new Java8Bundle());
        bootstrap.addBundle(new ViewBundle<RabbitOperationsConfiguration>());
        bootstrap.addBundle(shiro);
        bootstrap.addBundle(new ConfiguredAssetsBundle("/web/", "/web/"));
    }

    @Override
    public void run(RabbitOperationsConfiguration configuration,
                    Environment environment) {
        environment.jersey().register(new DashboardResource());
        environment.jersey().register(new ApplicationResource());
        environment.jersey().register(new ConfigurationResource());

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck("hello");
        environment.healthChecks().register("template", healthCheck);
    }

    private final ShiroBundle<RabbitOperationsConfiguration> shiro = new ShiroBundle<RabbitOperationsConfiguration>() {

        @Override
        protected ShiroConfiguration narrow(RabbitOperationsConfiguration configuration) {
            return configuration.shiro;
        }
    };

}