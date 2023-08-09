package com.gruchh.maintenance.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MACHINES")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate productionDate;
    private LocalDate lastMainenanceDate;
    private String manufacturer;

    @OneToMany(mappedBy = "machineIssue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WorkOrder> workOrderSet = new HashSet<>();

}
