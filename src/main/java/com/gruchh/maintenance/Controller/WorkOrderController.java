package com.gruchh.maintenance.Controller;

import com.gruchh.maintenance.Controller.DTO.WorkOrderDTO;
import com.gruchh.maintenance.Service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/WorkOrder")
@RestController
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    @RequestMapping()
    public ResponseEntity<List<WorkOrderDTO>> getAllWorkOrder() {

        return ResponseEntity.ok().body(workOrderService.getAllWorkOrders());
    }
}
