package com.travelsupermarket.latedeals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.moneysupermarket.services.common.application.dropwizard.configuration.ServiceConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Configuration class for the Reference Data Service Application.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LateDealsConfiguration extends ServiceConfiguration {

    @NotEmpty
    private String healthCheckPath = "/global/tsm/late-deals/v1/status";

    public String getHealthCheckPath() {
        return healthCheckPath;
    }

    public void setHealthCheckPath(String healthCheckPath) {
        this.healthCheckPath = healthCheckPath;
    }
}
