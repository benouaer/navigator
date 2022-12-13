package com.yoti.roomba.navigator.persistence;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NavigationRepository extends CrudRepository<NavigationRecord, Long> {

    List<NavigationRecord> findAll();

    List<NavigationRecord> findByCreatedDate(LocalDateTime createdDate);

}
