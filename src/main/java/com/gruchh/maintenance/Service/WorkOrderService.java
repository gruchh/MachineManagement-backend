package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.WorkOrder;

import java.util.List;

public interface WorkOrderService {

    void saveWorkOrders(List<WorkOrder> workOrderList);
}
