package com.southsidesoft.rabbitOperations;

import com.nefariouszhen.dropwizard.assets.ConfiguredAssetsBundle;
import com.southsidesoft.rabbitOperations.resources.DashboardResource;
import com.southsidesoft.rabbitOperations.resources.api.v1.ApplicationResource;
import com.southsidesoft.rabbitOperations.resources.api.v1.ClusterResource;
import com.southsidesoft.rabbitOperations.resources.api.v1.ConfigurationResource;
import com.southsidesoft.rabbitOperations.resources.api.v1.MetaDataResource;
import io.dropwizard.Application;
import io.dropwizard.elasticsearch.health.EsClusterHealthCheck;
import io.dropwizard.elasticsearch.managed.ManagedEsClient;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
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
        final ManagedEsClient managedClient = new ManagedEsClient(configuration.getEsConfiguration());
        environment.lifecycle().manage(managedClient);

        environment.jersey().register(new DashboardResource());
        environment.jersey().register(new ApplicationResource());
        environment.jersey().register(new ConfigurationResource());
        environment.jersey().register(new MetaDataResource());
        environment.jersey().register(new ClusterResource(managedClient));

        environment.healthChecks().register("ES cluster health", new EsClusterHealthCheck(managedClient.getClient()));
    }

    private final ShiroBundle<RabbitOperationsConfiguration> shiro = new ShiroBundle<RabbitOperationsConfiguration>() {

        @Override
        protected ShiroConfiguration narrow(RabbitOperationsConfiguration configuration) {
            return configuration.shiro;
        }
    };

}