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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machineEvent_id")
    private Machine machineEventOccured;
    @Enumerated(EnumType.STRING)
    private EventType eventType;


}
