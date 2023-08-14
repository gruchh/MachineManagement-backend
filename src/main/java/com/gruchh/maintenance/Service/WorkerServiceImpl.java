package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.WorkOrder;
import com.gruchh.maintenance.Entity.Worker;
import com.gruchh.maintenance.Repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkerServiceImpl implements WorkerService{

    private final WorkerRepository workerRepository;

    @Override
    public void saveWorkers(List<Worker> workerList) {
        workerRepository.saveAll(workerList);
    }
}
