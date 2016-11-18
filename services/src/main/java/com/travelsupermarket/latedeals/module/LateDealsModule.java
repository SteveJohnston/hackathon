package com.travelsupermarket.latedeals.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.travelsupermarket.latedeals.resource.LateDealsResource;
import com.travelsupermarket.latedeals.resource.PriceDataResource;
import com.travelsupermarket.latedeals.resource.RootResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Guice module. Creates data accessors and Dropwizard resources.
 */
public class LateDealsModule extends AbstractModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(LateDealsModule.class);

    @Override
    protected void configure() {

    }

    /**
     * Creates and provides a RootResource.
     *
     * @param lateDealsResource  The late deals resource.
     * @return A Root Resource.
     */
    @Provides
    public RootResource RootResource(final LateDealsResource lateDealsResource) {
        return new RootResource(lateDealsResource, new PriceDataResource());
    }

    /**
     * Creates and provides an Late Deals resource.
     *
     * @return A holidays specific Late Deals Resource.
     */
    @Provides
    public LateDealsResource holidaysAutoCompleteResource() {
        return new LateDealsResource(

        );
    }

    /**
     * Creates and provides an ObjectMapper.
     *
     * @return the ObjectMapper
     */
    @Provides
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}
