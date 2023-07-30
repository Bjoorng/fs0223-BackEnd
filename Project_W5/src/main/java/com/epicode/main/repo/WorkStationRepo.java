package com.epicode.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.main.classes.WorkStation;
import com.epicode.main.enums.Type;

@Repository
public interface WorkStationRepo extends CrudRepository<WorkStation, Long>{
		 List<WorkStation> findByType(Type type); 
		 
		 @Query("SELECT ws FROM WorkStation ws WHERE ws.building.city = :city")
		 List<WorkStation> findByCity(String city);
}
