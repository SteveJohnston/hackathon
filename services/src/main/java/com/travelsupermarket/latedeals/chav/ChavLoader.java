package com.travelsupermarket.latedeals.chav;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;
import com.travelsupermarket.latedeals.locations.Location;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChavLoader {

    private static final Splitter SPLITTER = Splitter.on("|");
    private static final String RESOURCES_LOCATIONS_JSON = "chav.json";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Map<Integer, Chav> loadChavs() {
        ImmutableMap.Builder<Integer, Chav> chavMap = ImmutableMap.builder();
        try {
            String json = Resources.toString(Resources.getResource(RESOURCES_LOCATIONS_JSON), Charsets.UTF_8);
            List<Chav> locations = SPLITTER.splitToList(json).stream().map(string -> {
                try {
                    return MAPPER.readValue(string, Chav.class);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }).filter(chav -> chav != null).collect(Collectors.toList());
            locations.forEach(chav -> chavMap.put(chav.getChavScore(), chav));
        } catch (IOException ex) {
            return Collections.EMPTY_MAP;
        }
        return chavMap.build();
    }
}
