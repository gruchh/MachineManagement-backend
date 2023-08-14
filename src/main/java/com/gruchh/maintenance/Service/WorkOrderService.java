package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Controller.DTO.WorkOrderDTO;
import com.gruchh.maintenance.Entity.WorkOrder;

import java.util.List;

public interface WorkOrderService {

    void saveWorkOrders(List<WorkOrder> workOrderList);

    List<WorkOrderDTO> getAllWorkOrders();
}
