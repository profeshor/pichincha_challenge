package com.pichincha.test.pichincha.models;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
    Movement findTopByOrderByIdDesc();
    List<Movement> findAllByLocalDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
