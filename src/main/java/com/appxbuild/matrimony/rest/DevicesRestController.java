package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Devices;
import com.appxbuild.matrimony.service.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DevicesRestController {

    private DevicesService devicesService;

    @Autowired
    public DevicesRestController(DevicesService theDevicesService){
        devicesService = theDevicesService;
    }

    // expose "/devices" and return a list of Devices
    @GetMapping("/devices")
    public List<Devices> findAll(){
        return devicesService.findAll();
    }

    // add mapping for Get "/devices/{deviceId}"
    @GetMapping("/devices/{deviceId}")
    public Devices getDevice(@PathVariable int deviceId){
        Devices theDevice = devicesService.findById(deviceId);
        if(theDevice == null){
            throw new RuntimeException("Device is not found" + deviceId);
        }
        return theDevice;
    }

     //add mapping for POST "/devices" - add new Device
    @PostMapping("/devices")
    public Devices addDevice(@RequestBody Devices theDevices){
        theDevices.setId(0);
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theDevices.setCreated(timestamp);
        theDevices.setModified(null);
        Devices newDevice = devicesService.save(theDevices);
        return newDevice;
    }

    // add mapping for PUT "/devices" - update existing Device
    @PutMapping("/devices")
    public Devices updateDevice(@RequestBody Devices theDevices){
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theDevices.setModified(timestamp);
        Devices newDevice = devicesService.save(theDevices);
        return newDevice;
    }

    // add mapping for DELETE "/devices/{deviceId}" - delete Device
    @DeleteMapping("/devices/{deviceId}")
    public String deleteAgency(@PathVariable int deviceId){
        Devices theAgency = devicesService.findById(deviceId);
        devicesService.deleteById(deviceId);
        // throw exception if null
        if (theAgency == null){
            throw new RuntimeException("Device id is not found - " + deviceId);
        }
        return "Deleted Device id - " + deviceId;
    }
}
