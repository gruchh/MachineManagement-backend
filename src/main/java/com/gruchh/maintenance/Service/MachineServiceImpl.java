package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.Machine;
import com.gruchh.maintenance.Repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MachineServiceImpl implements MachineService {

    private final MachineRepository machineRepository;

    @Override
    public void saveMachines(List<Machine> machineList) {
        machineRepository.saveAll(machineList);
    }
}
