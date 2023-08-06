package com.main.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.main.classes.Laptop;
import com.main.classes.Smartphone;
import com.main.classes.Tablet;
import com.main.classes.User;
import com.main.enums.DeviceState;
import com.main.service.DevicesService;
import com.main.service.UserService;

@Component
public class DevicesRunner implements ApplicationRunner{
	
	@Autowired DevicesService disps;
	@Autowired UserService ussvc;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Runner...");
		
      User u1 = ussvc.findUserbyId(1);
      System.out.println(u1);
      
      User u2 = ussvc.findUserbyId(2);
      System.out.println(u2);
      
      User u3 = ussvc.findUserbyId(3);
      System.out.println(u3);
      
      User u4 = ussvc.findUserbyId(4);
      System.out.println(u4);
      		
      disps.updateDevice(1, u1, DeviceState.ASSIGNED);
      disps.updateDevice(2, u2, DeviceState.REPAIRING);
      disps.updateDevice(3, u3, DeviceState.ASSIGNED);

	}
}
