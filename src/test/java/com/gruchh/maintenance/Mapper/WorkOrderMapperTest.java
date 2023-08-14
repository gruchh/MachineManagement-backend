package com.gruchh.maintenance.Mapper;

import com.gruchh.maintenance.Controller.DTO.WorkOrderDTO;
import com.gruchh.maintenance.Entity.Machine;
import com.gruchh.maintenance.Entity.WorkOrder;
import com.gruchh.maintenance.Entity.WorkOrderType;
import com.gruchh.maintenance.Entity.Worker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class WorkOrderMapperTest {

    @InjectMocks
    private WorkOrderMapper workOrderMapper;

    @Test
    void shouldMapToWorkOrderDTOWithCorrectData() {
        // Given
        Long id = 1L;
        String description = "Lorem ipsum";
        WorkOrderType workOrderType = WorkOrderType.ORDER_PARTS;
        Machine machine = Machine.builder().name("COMAU Robot").build();
        Worker worker = Worker.builder().name("Janek").build();
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 2, 1);

        WorkOrder workOrder = WorkOrder.builder()
                .id(id)
                .description(description)
                .workOrderType(workOrderType)
                .machineIssue(machine)
                .worker(worker)
                .generationDate(startDate)
                .deadlineDate(endDate)
                .build();

        // When
        WorkOrderDTO workOrderDTO = workOrderMapper.mapToWorkOrderDTO(workOrder);

        // Then
        assertEquals(id, workOrderDTO.id());
        assertEquals(description, workOrderDTO.description());
        assertEquals(workOrderType, workOrderDTO.workOrderType());
        assertEquals(machine.getName(), workOrderDTO.machineName());
        assertEquals(worker.getName(), workOrderDTO.workerName());
        assertEquals(startDate, workOrderDTO.generationDate());
        assertEquals(endDate, workOrderDTO.deadlineDate());
    }

    @Test
    void shouldThrowExceptionWhileMapToWorkOrderDTOWithNull() {

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> workOrderMapper.mapToWorkOrderDTO(null));
    }

}