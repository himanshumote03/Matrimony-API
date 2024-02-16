package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.DevicesDAO;
import com.appxbuild.matrimony.entity.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevicesServiceImpl implements DevicesService {

    private DevicesDAO devicesDAO;

    @Autowired
    public DevicesServiceImpl(DevicesDAO theDevicesDAO){
        devicesDAO = theDevicesDAO;
    }


    @Override
    public List<Devices> findAll() {
        return devicesDAO.findAll();
    }

    @Override
    public Devices findById(int theId) {
        Optional<Devices> result = devicesDAO.findById(theId);

        Devices theDevice = null;
        if (result.isPresent()){
            theDevice = result.get();
        }
        else {
            throw new RuntimeException("Did not find device id - " + theId);
        }
        return theDevice;
    }

    @Override
    public Devices save(Devices theDevices) {
        return devicesDAO.save(theDevices);
    }


    @Override
    public void deleteById(int theId) {
        devicesDAO.deleteById(theId);
    }
}
