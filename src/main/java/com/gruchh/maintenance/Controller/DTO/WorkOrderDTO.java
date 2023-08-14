package com.gruchh.maintenance.Controller.DTO;

import com.gruchh.maintenance.Entity.WorkOrderType;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record WorkOrderDTO(Long id, String description, WorkOrderType workOrderType, LocalDate generationDate,
                           LocalDate deadlineDate, String workerName, String machineName
) {
}
