package com.travelsupermarket.latedeals;

import com.codahale.metrics.servlets.HealthCheckServlet;
import com.google.inject.Injector;
import com.travelsupermarket.http.error.handler.InvalidUrlParameterHandler;
import com.travelsupermarket.http.error.handler.MethodNotAllowedHandler;
import com.travelsupermarket.http.error.handler.NotFoundHandler;
import com.travelsupermarket.latedeals.health.LateDealsHealthCheck;
import com.travelsupermarket.latedeals.module.LateDealsModule;
import com.travelsupermarket.latedeals.resource.RootResource;
import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

/**
 * Main class for the Reference Data Service Application. Contains the main method of this Dropwizard application.
 * Initialises the application and registers resources.
 */
public class LateDealsApplication extends Application<LateDealsConfiguration> {

    /**
     * Name of the elasticsearch health checker.
     */
    public static final String APPLICATION_HEALTH_CHECK = "application";

    private GuiceBundle<LateDealsConfiguration> bundle;

    /**
     * Main method required for starting this Dropwizard application.
     *
     * @param args arguments for starting the application.
     * @throws Exception Exception preventing running of the application.
     */
    public static void main(String[] args) throws Exception {
        new LateDealsApplication().run(args);
    }

    /**
     * Initialize method. Configures the Guice modules that are included as part of this Dropwizard application.
     *
     * @param bootstrap Handled and passed in by the Dropwizard platform.
     */
    @Override
    public void initialize(Bootstrap<LateDealsConfiguration> bootstrap) {
        final GuiceBundle<LateDealsConfiguration> bundle =
                GuiceBundle.<LateDealsConfiguration>builder()
                        .modules(new LateDealsModule())
                        .build();
        setGuiceBundle(bundle);
        bootstrap.addBundle(bundle);
    }

    protected void setGuiceBundle(GuiceBundle<LateDealsConfiguration> bundle) {
        this.bundle = bundle;
    }

    /**
     * Run method. Registers the resources and health checks against the environment.
     *
     * @param config      Configuration settings for this application.
     * @param environment Dropwizard environment for which to register resources against.
     * @throws Exception Exception detailing errors registering resources.
     */
    @Override
    public void run(LateDealsConfiguration config, Environment environment) throws Exception {
        registerResources(environment.jersey());
        registerAdapters(environment.jersey());
        registerHealthChecks(environment, config.getHealthCheckPath());
    }

    /**
     * Register resources against the Dropwizard environment.
     *
     * @param environment The dropwizard environment.
     */
    private void registerResources(JerseyEnvironment environment) {
        final Injector injector = bundle.getInjector();
        environment.register(injector.getInstance(RootResource.class));
    }

    /**
     * Registers the handler adapters to the environment which intercept exceptions and convert them into TSM standard
     * error outputs to be set to the client.
     *
     * @param environment The jersey environment for this Dropwizard app.
     */
    private static void registerAdapters(JerseyEnvironment environment) {
        environment.register(new InvalidUrlParameterHandler());
        environment.register(new NotFoundHandler());
        environment.register(new MethodNotAllowedHandler());
    }

    /**
     * Register health checks against the Dropwizard environment.
     *
     * @param environment     The dropwizard environment.
     * @param healthCheckPath The health check path.
     */
    private void registerHealthChecks(Environment environment, String healthCheckPath) {
        final Injector injector = bundle.getInjector();
        environment.healthChecks().register(
                APPLICATION_HEALTH_CHECK, injector.getInstance(LateDealsHealthCheck.class));
        environment.servlets().addServlet("HealthCheckServlet", new HealthCheckServlet(environment.healthChecks()))
                .addMapping(healthCheckPath);
    }
}
