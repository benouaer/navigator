package com.yoti.roomba.navigator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoti.roomba.navigator.model.NavigationRequest;
import jakarta.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NavigationRequestConverter implements AttributeConverter<NavigationRequest, String> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(NavigationRequest navigationRequest) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(navigationRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    @Override
    public NavigationRequest convertToEntityAttribute(String json) {

        NavigationRequest navigationRequest = null;
        try {
            navigationRequest = objectMapper.readValue(json, new TypeReference<>() {});
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        return navigationRequest;
    }
}
