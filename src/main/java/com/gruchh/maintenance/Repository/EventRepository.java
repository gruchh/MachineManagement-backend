package com.gruchh.maintenance.Repository;

import com.gruchh.maintenance.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
