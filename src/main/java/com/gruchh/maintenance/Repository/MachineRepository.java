package com.gruchh.maintenance.Repository;

import com.gruchh.maintenance.Entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
