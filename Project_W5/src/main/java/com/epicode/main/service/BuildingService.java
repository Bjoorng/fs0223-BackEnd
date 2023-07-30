package com.epicode.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.main.classes.Building;
import com.epicode.main.repo.BuildingRepo;

@Service
public class BuildingService {

	Logger log = LoggerFactory.getLogger(BuildingService.class);
	
	@Autowired BuildingRepo buildingRepo;
	@Autowired @Qualifier("building") private ObjectProvider<Building> edificioProvider;
	
	public Building createEdificio(String name, String address, String city){
		Building bu = edificioProvider.getObject();
		bu.setName(name);
		bu.setAddress(address);
		bu.setCity(city);
        
        System.out.println(bu);
        buildingRepo.save(bu);
        log.info("Bulding" + bu.getName()+ " saved. ");
        return bu;
    }
	
	public List<Building> findAllEdifici() {
        return (List<Building>) buildingRepo.findAll();
    }
    
    public Building findEdificioById(Long id) {
		System.out.println("Building found");
    	return buildingRepo.findById(id).get();
    }
    
    public void deleteEdificioById(Long id) {
    	System.out.println("Building has been deleted");
    	buildingRepo.deleteById(id);
    }
    
}
