package com.travelsupermarket.latedeals.locations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationsLoader {

    private static final Splitter SPLITTER = Splitter.on("|");
    private static final String RESOURCES_LOCATIONS_JSON = "locations.json";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Map<String, Location> loadLocations() {
        ImmutableMap.Builder<String, Location> locationsMap = ImmutableMap.builder();
        try {
            String json = Resources.toString(Resources.getResource(RESOURCES_LOCATIONS_JSON), Charsets.UTF_8);
            List<Location> locations = SPLITTER.splitToList(json).stream().map(string -> {
                try {
                    return MAPPER.readValue(string, Location.class);
                } catch (Exception ex) {
                    return null;
                }
            }).filter(location -> location != null).collect(Collectors.toList());
            locations.forEach(location -> locationsMap.put(location.getLocationId(), location));
        } catch (IOException ex) {
            return Collections.EMPTY_MAP;
        }
        return locationsMap.build();
    }
}
