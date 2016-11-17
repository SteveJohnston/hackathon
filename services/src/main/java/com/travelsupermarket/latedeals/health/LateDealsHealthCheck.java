package com.travelsupermarket.latedeals.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Health check for this Dropwizard application.
 */
public class LateDealsHealthCheck extends HealthCheck {

    /**
     * Constructor.
     */
    public LateDealsHealthCheck() {

    }

    /**
     * Health Check
     */
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
