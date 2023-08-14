package com.gruchh.maintenance.Controller;

import com.gruchh.maintenance.Entity.*;
import com.gruchh.maintenance.Service.EventService;
import com.gruchh.maintenance.Service.MachineService;
import com.gruchh.maintenance.Service.WorkOrderService;
import com.gruchh.maintenance.Service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class HomeController {

    private final WorkerService workerService;
    private final WorkOrderService workOrderService;
    private final EventService eventService;
    private final MachineService machineService;

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStart() {

        Phone ph1 = Phone.builder()
                .model("K500i")
                .purchaseDate(LocalDate.of(2022, 5, 2))
                .phoneNumber("542-984-334")
                .build();

        Phone ph2 = Phone.builder()
                .model("K320d")
                .purchaseDate(LocalDate.of(2020, 3, 22))
                .phoneNumber("666-555-444")
                .build();

        Worker worker1 = Worker.builder()
                .name("Bibi")
                .surname("Dżej dżej")
                .salary(BigDecimal.valueOf(4000))
                .hireData(LocalDate.of(2022, 3, 12))
                .position("Automatic")
                .phone(ph1)
                .build();

        Worker worker2 = Worker.builder()
                .name("Tomisław")
                .surname("Tajner")
                .salary(BigDecimal.valueOf(4500))
                .hireData(LocalDate.of(2021, 2, 19))
                .position("Mechanic")
                .phone(ph2)
                .build();

        workerService.saveWorkers(Arrays.asList(worker1, worker2));

        Machine machine1 = Machine.builder()
                .name("Driller")
                .manufacturer("xxx")
                .productionDate(LocalDate.of(1992, 4, 1))
                .lastMainenanceDate(LocalDate.of(2023, 1, 2))
                .build();

        Machine machine2 = Machine.builder()
                .name("Milling machine")
                .manufacturer("yyy")
                .productionDate(LocalDate.of(1992, 4, 1))
                .lastMainenanceDate(LocalDate.of(2023, 1, 2))
                .build();
        machineService.saveMachines(Arrays.asList(machine1, machine2));

        WorkOrder workOrder1 = WorkOrder.builder()
                .machineIssue(machine1)
                .description("Silencer replace")
                .workOrderType(WorkOrderType.REPAIR_MACHINE)
                .generationDate(LocalDate.of(2023, 8, 9))
                .worker(worker1)
                .build();

        WorkOrder workOrder2 = WorkOrder.builder()
                .machineIssue(machine1)
                .description("Sensor replace")
                .workOrderType(WorkOrderType.REPAIR_MACHINE)
                .generationDate(LocalDate.of(2023, 8, 12))
                .worker(worker1)
                .build();

        WorkOrder workOrder3 = WorkOrder.builder()
                .machineIssue(machine2)
                .description("New PLC ")
                .workOrderType(WorkOrderType.ORDER_PARTS)
                .generationDate(LocalDate.of(2023, 8, 14))
                .worker(worker1)
                .build();

        WorkOrder workOrder4 = WorkOrder.builder()
                .machineIssue(machine1)
                .description("Add new alarm")
                .workOrderType(WorkOrderType.IMPROVE_MACHINE)
                .generationDate(LocalDate.of(2023, 8, 14))
                .worker(worker2)
                .build();

        WorkOrder workOrder5 = WorkOrder.builder()
                .machineIssue(machine2)
                .description("Verify thermocouples")
                .workOrderType(WorkOrderType.SPECIFY_PROBLEM)
                .generationDate(LocalDate.of(2023, 8, 15))
                .worker(worker2)
                .build();

        workOrderService.saveWorkOrders(Arrays.asList(workOrder1, workOrder2, workOrder3, workOrder4, workOrder5));

        Event event1 = Event.builder()
                .description("PLC stop")
                .eventType(EventType.BREAKDOWN)
                .startDate(LocalDate.of(2023, 7, 8))
                .machineEventOccured(machine2)
                .workerSet(Set.of(worker1, worker2))
                .build();

        Event event2 = Event.builder()
                .description("Can't run machine")
                .eventType(EventType.CALL)
                .startDate(LocalDate.of(2023, 7, 8))
                .machineEventOccured(machine1)
                .workerSet(Set.of(worker1, worker2))
                .build();

        eventService.saveEvents(Arrays.asList(event1, event2));
    }
}