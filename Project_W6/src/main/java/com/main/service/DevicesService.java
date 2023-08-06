package com.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.classes.Devices;
import com.main.classes.Laptop;
import com.main.classes.Smartphone;
import com.main.classes.Tablet;
import com.main.classes.User;
import com.main.enums.DeviceState;
import com.main.repositories.DevicesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DevicesService {
	
	Logger log = LoggerFactory.getLogger(DevicesService.class);
	
	@Autowired DevicesRepository devicesRepo;
	@Autowired @Qualifier("smartphoneBean") private ObjectProvider<Smartphone> smartphoneProvider;
	@Autowired @Qualifier("tabletBean") private ObjectProvider<Tablet> tabletProvider;
	@Autowired @Qualifier("laptopBean") private ObjectProvider<Laptop> laptopProvider;
	
	public Devices createDispositivo(Devices dev) {
	    if (dev instanceof Smartphone) {
	        Smartphone s = smartphoneProvider.getObject();
	        devicesRepo.save(s);
	        return s;
	    } else if (dev instanceof Tablet) {
	        Tablet t = tabletProvider.getObject();
	        devicesRepo.save(t);
	        return t;
	    } else if (dev instanceof Laptop) {
	    	Laptop lp = laptopProvider.getObject();
	    	devicesRepo.save(lp);
	        return lp;
	    } else {
	        log.error("Dispositivo non esistente.");
	        return null;
	    }
	}
	
	public void updateDevice(long id, User user, DeviceState status) {
		Devices d = findDeviceById(id);
		d.setUtente(user);
		d.setStatus(status);
		devicesRepo.save(d);
	}
	
	public void removeUpdateDevice(long id) {
	    Devices d = findDeviceById(id);
	    d.setUtente(null);
	    d.setStatus(DeviceState.AVAILABLE);
	    devicesRepo.save(d);
	}
	
	public List<Devices> findAllDevices() {
        return (List<Devices>)devicesRepo.findAll();
    }
	
	public Devices findDeviceById(long id) {
    	if(!devicesRepo.existsById(id)) {
			throw new EntityNotFoundException("Device doesn't exist");
		}
		return devicesRepo.findById(id).get();
    }
	
	public List<Devices> findDevicesByStato(DeviceState status) {
        return devicesRepo.findByState(status);
    }
	
	 public String deleteDispositivoById(long id) {
	    	if (devicesRepo.existsById(id)) {
	    		Devices d = findDeviceById(id);
	    		devicesRepo.delete(d);
	            return "Device deleted";
	        } else {
	            return "No devices matching the id";
	        }
	    }
}
