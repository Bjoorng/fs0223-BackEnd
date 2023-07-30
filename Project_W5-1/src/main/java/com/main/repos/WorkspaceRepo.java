package com.main.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.classes.Workspace;
import com.main.enums.WorkspaceType;

@Repository
public interface WorkspaceRepo extends CrudRepository<Workspace, Long>{
	
	Optional<Workspace> findById(Long id);
	List<Workspace> findByAvailable(boolean isVacant);
	List<Workspace> findByReservationDate(LocalDate reservation);
	List<Workspace> findByType(WorkspaceType type);
	List<Workspace> findByBuildingIdAndTypeAndMaxOccupancyGreaterThan(Long buildingId, WorkspaceType type, int occupancy);
	
}
