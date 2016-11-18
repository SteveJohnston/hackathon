package com.travelsupermarket.latedeals.resource;

import javax.ws.rs.Path;

/**
 * Base resource class to be extended by channel specific resources.
 */
@Path("/global/tsm/late-deals/v1")
public class RootResource {

    private final LateDealsResource lateDealsResource;
//    private final PriceDataResource priceDataResource;

    /**
     * Creates a root resource and populates it with resources and paths.
     *
     * @param lateDealsResource            The details resource.
     */
    public RootResource(LateDealsResource lateDealsResource) {
        this.lateDealsResource = lateDealsResource;
//        this.priceDataResource = priceDataResource;
    }

    @Path("/holidays")
    public LateDealsResource getHolidaysLateDealsResource() {
        return this.lateDealsResource;
    }

//    @Path("/price-data")
//    public PriceDataResource getPriceDataResouce() {
//        return this.priceDataResource;
//    }
}
