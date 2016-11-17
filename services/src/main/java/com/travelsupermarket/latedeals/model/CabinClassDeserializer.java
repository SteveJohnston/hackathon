package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Deserializes a Cabin Class value
 */
public class CabinClassDeserializer extends JsonDeserializer<CabinClassType> {

    /**
     * Performs deserialization
     * @param jp the parser from which the values must be read
     * @param ctxt Jackson context
     * @return a CabinClass instance
     * @throws IOException if deserialization goes wrong
     */
    @Override
    public CabinClassType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException{
        String  value = jp.getText();

        return CabinClassType.fromJson(value);
    }
}