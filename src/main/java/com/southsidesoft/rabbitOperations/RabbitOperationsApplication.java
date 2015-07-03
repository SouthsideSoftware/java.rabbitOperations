package com.southsidesoft.rabbitOperations;

import com.nefariouszhen.dropwizard.assets.ConfiguredAssetsBundle;
import com.southsidesoft.rabbitOperations.resources.DashboardResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.southsidesoft.rabbitOperations.resources.RabbitOperationsResource;
import com.southsidesoft.rabbitOperations.health.TemplateHealthCheck;
import io.dropwizard.views.ViewBundle;

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
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/assets/"));
    }

    @Override
    public void run(RabbitOperationsConfiguration configuration,
                    Environment environment) {
        final RabbitOperationsResource resource = new RabbitOperationsResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        environment.jersey().register(new DashboardResource());

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck("hello");
        environment.healthChecks().register("template", healthCheck);
    }

}