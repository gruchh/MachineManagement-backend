package com.gruchh.maintenance.Mapper;

import com.gruchh.maintenance.Controller.DTO.WorkOrderDTO;
import com.gruchh.maintenance.Entity.WorkOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WorkOrderMapper {

    public WorkOrderDTO mapToWorkOrderDTO(WorkOrder workOrder) {

        if (workOrder == null) {
            throw new IllegalArgumentException("Work Order cannot be null");
        }

        return WorkOrderDTO.builder()
                .id(workOrder.getId())
                .description(workOrder.getDescription())
                .workOrderType(workOrder.getWorkOrderType())
                .generationDate(workOrder.getGenerationDate())
                .deadlineDate(workOrder.getDeadlineDate())
                .machineName(workOrder.getMachineIssue().getName())
                .workerName(workOrder.getWorker().getName())
                .build();
    }
}
