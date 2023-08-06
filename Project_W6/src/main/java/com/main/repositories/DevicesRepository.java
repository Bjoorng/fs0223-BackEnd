package com.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.main.classes.Devices;
import com.main.enums.DeviceState;

public interface DevicesRepository extends CrudRepository<Devices, Long>{
	
	List<Devices> findByState(DeviceState state);
	
}
