package com.main.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.classes.Building;

@Repository
public interface BuildingRepo  extends CrudRepository<Building, Long> {
	
	Optional<Building> findById(Long id);
}
