package com.main.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.main.classes.Reservation;
import com.main.classes.User;
import com.main.classes.Workspace;

public interface ReservationRepo {
	 
	List<Reservation> findByReservationDateAndWorkspaceId(LocalDate date, Long workspaceId);
	List<Reservation> findByUser(User user);
	List<Reservation> findByUserAndReservationDate(User user, LocalDate reservationDate);
	void save(Reservation reservation);
	Optional<Workspace> getOne(Long workspaceId);
	
}
