package com.southsidesoft.rabbitOperations;

import com.nefariouszhen.dropwizard.assets.AssetsBundleConfiguration;
import com.nefariouszhen.dropwizard.assets.AssetsConfiguration;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.elasticsearch.config.EsConfiguration;
import org.hibernate.validator.constraints.NotEmpty;
import org.secnod.dropwizard.shiro.ShiroConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RabbitOperationsConfiguration extends Configuration implements AssetsBundleConfiguration {
    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    private final EsConfiguration esConfiguration = new EsConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    protected final ShiroConfiguration shiro = new ShiroConfiguration();

    @Override
    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }

    public EsConfiguration getEsConfiguration(){
        return esConfiguration;
    }
}