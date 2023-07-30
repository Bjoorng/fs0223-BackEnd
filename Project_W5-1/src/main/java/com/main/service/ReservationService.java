package com.main.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.classes.Reservation;
import com.main.classes.User;
import com.main.classes.Workspace;
import com.main.repos.ReservationRepo;

@Service
public class ReservationService {

	Logger log = LoggerFactory.getLogger(ReservationService.class);
	@Autowired
	ReservationRepo rr;
	@Autowired
	@Qualifier("building")
	private ObjectProvider<Reservation> edificioProvider;

	public boolean createReservation(LocalDate reservationDate, Long workspaceId, User user) {
		List<Reservation> existingUserReservations = rr.findByUserAndReservationDate(user, reservationDate);
		if (!existingUserReservations.isEmpty()) {
			return false;
		}
		List<Reservation> existingReservations = rr.findByReservationDateAndWorkspaceId(reservationDate, workspaceId);
		if (!existingReservations.isEmpty()) {
			return false;
		}
		Reservation reservation = new Reservation();
		reservation.setReservationDate(reservationDate);
		Workspace workspace = getWorkspaceById(workspaceId);
		reservation.setWorkspace(workspace);
		reservation.setUser(user);
		rr.save(reservation);
		return true;
	}

	private Workspace getWorkspaceById(Long workspaceId) {
		Optional<Workspace> workspaceOpt = rr.getOne(workspaceId);
		if (workspaceOpt.isEmpty()) {
			throw new IllegalArgumentException("Postazione non trovata con ID: " + workspaceId);
		}
		return workspaceOpt.get();
	}
}
