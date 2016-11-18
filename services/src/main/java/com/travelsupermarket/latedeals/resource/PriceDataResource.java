package com.travelsupermarket.latedeals.resource;

import com.codahale.metrics.annotation.Timed;
import com.mongodb.*;
import com.travelsupermarket.http.error.exception.InvalidUrlParameterException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by thomas.dittmer on 17/11/2016.
 */
public class PriceDataResource {

    /**
     * Gets a result set
     */
    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/price-data/{Id}/{locationId}/{departureIata}/{departureDate}")
    public String results(@PathParam("locationId") String locationId,
                          @PathParam("departureIata") String departureIata,
                          @PathParam("departureDate") String departureDate) throws InvalidUrlParameterException {

        try {
            MongoClient mongo = new MongoClient( "hackathon-937194125.eu-west-1.elb.amazonaws.com" , 27017 );
            DB db = mongo.getDB("travelate");
            DBCollection table = db.getCollection("priceHistory");

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("locationId", locationId);
            searchQuery.put("departureIata", departureIata);
            searchQuery.put("departureDate", departureDate);

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

        } catch (Exception ex) {
            return ex.toString();

        }
        throw new InvalidUrlParameterException("You sent me crap", "", "", "");
    }
}
