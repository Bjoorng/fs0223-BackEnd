package com.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.main.classes.Building;
import com.main.repos.BuildingRepo;

public class BuildingService {
	
	Logger log = LoggerFactory.getLogger(BuildingService.class);
	
	@Autowired BuildingRepo br;
	@Autowired @Qualifier("edificio") private ObjectProvider<Building> bp;
	
	public Building createBuilding(String name, String address, String city){
		Building ed = bp.getObject();
        ed.setName(name);
        ed.setAddress(address);
        ed.setCity(city);
        
        System.out.println(ed);
        br.save(ed);
        log.info("Edificio" + ed.getName()+ " saved. ");
        return ed;
	}
}
