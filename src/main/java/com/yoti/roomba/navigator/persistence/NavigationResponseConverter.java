package com.yoti.roomba.navigator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoti.roomba.navigator.model.NavigationResponse;
import jakarta.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NavigationResponseConverter implements AttributeConverter<NavigationResponse, String> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(NavigationResponse navigationResponse) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(navigationResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    @Override
    public NavigationResponse convertToEntityAttribute(String json) {

        NavigationResponse navigationResponse = null;
        try {
            navigationResponse = objectMapper.readValue(json, new TypeReference<>() {});
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        return navigationResponse;
    }
}
