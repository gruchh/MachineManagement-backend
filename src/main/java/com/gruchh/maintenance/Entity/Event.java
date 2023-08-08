package com.gruchh.maintenance.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    @ManyToMany
    @JoinTable(name = "event_worker",
            joinColumns = @JoinColumn(name = "event"),
            inverseJoinColumns = @JoinColumn(name = "worker_id"))
    private Set<Worker> workerSet;
    @ManyToMany
    @JoinTable(name = "event_machine",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "machine_id"))
    private Set<Machine> machine;
    @Enumerated(EnumType.STRING)
    private EventType eventType;


}
