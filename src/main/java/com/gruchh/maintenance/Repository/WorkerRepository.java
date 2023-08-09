package com.gruchh.maintenance.Repository;

import com.gruchh.maintenance.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
