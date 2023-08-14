package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.Worker;

import java.util.List;

public interface WorkerService {

    void saveWorkers(List<Worker> workerList);
}
