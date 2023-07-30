package com.main.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.classes.Building;
import com.main.classes.User;
import com.main.service.BuildingService;
import com.main.service.ReservationService;
import com.main.service.UserService;

@Component
public class Runner {
	
	@Autowired ReservationService rs;
	@Autowired BuildingService bs;
	@Autowired UserService us;
	
	public void run(String... args) throws Exception{
		System.out.println("Runner...");
		
		Building b1 = bs.createBuilding("B1", "Via 100", "Roma");
		Building b2 = bs.createBuilding("B2", "Via 199", "Milano");
		Building b3 = bs.createBuilding("B3", "Via 8282", "Catanzaro");
		
		User u1 = us.createUser("xXMarioTheBestXx", "Mario", "mariolino@gmail.com");
		User u2 = us.createUser("GiusepTheSlayer", "Giuseppe", "peppeilgrande@gmail.com");
		User u3 = us.createUser("Commando84", "Giancarlo", "cosenostre@gmail.com");
	} 
}
