package com.gruchh.maintenance.Service;

import com.gruchh.maintenance.Entity.Phone;
import com.gruchh.maintenance.Repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public void savePhones(List<Phone> phoneList) {
        phoneRepository.saveAll(phoneList);
    }
}
