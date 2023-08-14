package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.Machine;

import java.util.List;

public interface MachineService {

    void saveMachines(List<Machine> machineList);
}
