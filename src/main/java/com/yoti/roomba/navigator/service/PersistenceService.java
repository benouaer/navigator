package com.yoti.roomba.navigator.service;

import com.yoti.roomba.navigator.model.NavigationRequest;
import com.yoti.roomba.navigator.model.NavigationResponse;
import com.yoti.roomba.navigator.persistence.NavigationRecord;
import com.yoti.roomba.navigator.persistence.NavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersistenceService {

    @Autowired
    private NavigationRepository repository;

    public NavigationRecord saveNavigation(NavigationRequest request, NavigationResponse response) {
        return repository.save(new NavigationRecord(LocalDate.now(), request, response));
    }

    public List<NavigationRecord> getAllNavigations() {
        return repository.findAll();
    }

    public NavigationRecord getNavigation(Long id) {
        return repository.findById(id).orElse(new NavigationRecord());
    }

}
