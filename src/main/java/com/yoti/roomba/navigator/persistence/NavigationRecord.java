package com.yoti.roomba.navigator.persistence;

import com.yoti.roomba.navigator.model.NavigationRequest;
import com.yoti.roomba.navigator.model.NavigationResponse;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class NavigationRecord {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate createdDate;

    @Convert(converter = NavigationRequestConverter.class)
    private NavigationRequest request;

    @Convert(converter = NavigationResponseConverter.class)
    private NavigationResponse response;

    public NavigationRecord() {}

    public NavigationRecord(LocalDate createdDate,
                            NavigationRequest request,
                            NavigationResponse response) {
        this.createdDate = createdDate;
        this.request = request;
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public NavigationRequest getRequest() {
        return request;
    }

    public NavigationResponse getResponse() {
        return response;
    }
}
