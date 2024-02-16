package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Devices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DevicesService {

    List<Devices> findAll();

    Devices findById(int theId);

    Devices save(Devices theDevices);

    void deleteById(int theId);

}
