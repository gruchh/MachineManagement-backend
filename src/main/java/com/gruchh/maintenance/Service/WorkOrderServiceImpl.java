package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Controller.DTO.WorkOrderDTO;
import com.gruchh.maintenance.Entity.WorkOrder;
import com.gruchh.maintenance.Mapper.WorkOrderMapper;
import com.gruchh.maintenance.Repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final WorkOrderMapper workOrderMapper;

    @Override
    public void saveWorkOrders(List<WorkOrder> workOrderList) {
        workOrderRepository.saveAll(workOrderList);
    }

    @Override
    public List<WorkOrderDTO> getAllWorkOrders() {
        return workOrderRepository.findAll().stream().map(workOrderMapper::mapToWorkOrderDTO).collect(Collectors.toList());


    }
}
