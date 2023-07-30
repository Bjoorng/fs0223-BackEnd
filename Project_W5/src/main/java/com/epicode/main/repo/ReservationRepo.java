package com.epicode.main.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.epicode.main.classes.Reservation;
import com.epicode.main.classes.User;
import com.epicode.main.classes.WorkStation;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation, Long>{
	
	@Query("SELECT rs FROM Reservation rs WHERE rs.user.fullName = :fullName")
    List<Reservation> findByUser(String fullName);
	List<Reservation> findByUserAndResDate(User user, LocalDate resDate);
	
	@Query("SELECT rs FROM Reservation rs WHERE pr.workstation.type = :type")
	List<Reservation> findByType(@Param("tipo") String tipo);
	
	List<Reservation> findByDate(LocalDate date);
	List<Reservation> findByWsId(Long workspaceId);
	List<Reservation> findByResDateAndWsId(LocalDate resDate, Long workspaceId);
	Optional<WorkStation> getOne(Long workspaceId);
}
