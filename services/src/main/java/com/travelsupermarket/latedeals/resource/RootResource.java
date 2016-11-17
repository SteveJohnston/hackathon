package com.travelsupermarket.latedeals.resource;

import javax.ws.rs.Path;

/**
 * Base resource class to be extended by channel specific resources.
 */
@Path("/global/tsm/late-deals/v1")
public class RootResource {

    private final LateDealsResource lateDealsResource;

    /**
     * Creates a root resource and populates it with resources and paths.
     *
     * @param lateDealsResource            The details resource.
     */
    public RootResource(LateDealsResource lateDealsResource) {
        this.lateDealsResource = lateDealsResource;
    }

    @Path("/holidays")
    public LateDealsResource getHolidaysLateDealsResource() {
        return this.lateDealsResource;
    }
}
