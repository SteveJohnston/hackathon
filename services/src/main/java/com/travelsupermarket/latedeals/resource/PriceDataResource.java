package com.travelsupermarket.latedeals.resource;

import com.codahale.metrics.annotation.Timed;
import com.mongodb.*;
import com.travelsupermarket.http.error.exception.InvalidUrlParameterException;
import org.json.*;

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
    @Path("/{locationId}/{departureIata}/{departureDate}")
    public String results(@PathParam("locationId") String locationId,
                          @PathParam("departureIata") String departureIata,
                          @PathParam("departureDate") String departureDate) throws InvalidUrlParameterException {

        JSONObject returnObject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        try {
            MongoClient mongo = new MongoClient( "backoffice-hackathon.backoffice1.gb.tsm.internal", 27017 );
            DB db = mongo.getDB("travelate");
            DBCollection table = db.getCollection("priceHistory");

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("locationid", locationId);
            searchQuery.put("departureiata", departureIata);
            searchQuery.put("departuredate", departureDate);

            BasicDBObject fields = new BasicDBObject();
            fields.put("_id", 0);
            fields.put("searchdate", 1);
            fields.put("avgprice", 1);


            DBCursor cursor = table.find(searchQuery, fields);


            while (cursor.hasNext()) {
                BasicDBObject obj = (BasicDBObject) cursor.next();
                JSONObject jsonobj = new JSONObject();
                jsonobj.put("searchDate", obj.getString("searchdate"));
                jsonobj.put("avgPrice", obj.getString("avgprice"));

                jsonarray.put(jsonobj);
            }

            returnObject.put("locationId", locationId);
            returnObject.put("departureDate", departureDate);
            returnObject.put("departureIata", departureIata);
            returnObject.put("priceHistory", jsonarray);

        } catch (Exception ex) {
            return ex.toString();

        }
        return returnObject.toString();
    }
}
