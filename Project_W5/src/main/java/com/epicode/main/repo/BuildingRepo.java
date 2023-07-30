package com.epicode.main.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.main.classes.Building;

@Repository
public interface BuildingRepo extends CrudRepository<Building, Long>{
	 
}
