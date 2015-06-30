package com.southsidesoft.rabbitOperations;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.southsidesoft.rabbitOperations.resources.RabbitOperationsResource;
import com.southsidesoft.rabbitOperations.health.TemplateHealthCheck;

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
        // nothing to do yet
    }

    @Override
    public void run(RabbitOperationsConfiguration configuration,
                    Environment environment) {
        final RabbitOperationsResource resource = new RabbitOperationsResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}