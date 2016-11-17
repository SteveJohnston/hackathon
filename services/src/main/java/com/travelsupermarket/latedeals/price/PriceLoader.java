package com.travelsupermarket.latedeals.price;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;
import com.travelsupermarket.latedeals.chav.Chav;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceLoader {

    private static final Splitter SPLITTER = Splitter.on("|");
    private static final String RESOURCES_LOCATIONS_JSON = "price.json";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Map<Integer, Price> loadPrice() {
        ImmutableMap.Builder<Integer, Price> priceMap = ImmutableMap.builder();
        try {
            String json = Resources.toString(Resources.getResource(RESOURCES_LOCATIONS_JSON), Charsets.UTF_8);
            List<Price> locations = SPLITTER.splitToList(json).stream().map(string -> {
                try {
                    return MAPPER.readValue(string, Price.class);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }).filter(price -> price != null).collect(Collectors.toList());
            locations.forEach(price -> priceMap.put(price.getPriceScore(), price));
        } catch (IOException ex) {
            return Collections.EMPTY_MAP;
        }
        return priceMap.build();
    }
}
