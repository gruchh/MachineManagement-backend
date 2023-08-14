package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.WorkOrder;
import com.gruchh.maintenance.Repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    @Override
    public void saveWorkOrders(List<WorkOrder> workOrderList) {
        workOrderRepository.saveAll(workOrderList);
    }
}
