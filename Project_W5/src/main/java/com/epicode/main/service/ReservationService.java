package com.epicode.main.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.main.classes.Reservation;
import com.epicode.main.classes.User;
import com.epicode.main.classes.WorkStation;
import com.epicode.main.repo.ReservationRepo;



@Service
public class ReservationService {

	
Logger log = LoggerFactory.getLogger(ReservationService.class);
	
    @Autowired ReservationRepo reservationRepo;
    @Autowired @Qualifier("reservation") private ObjectProvider<Reservation> prenotazioneProvider;
	
	public Reservation createReservation(LocalDate date, User user, WorkStation workStation){
		Reservation rs = prenotazioneProvider.getObject();
        rs.setResDate(date);
        rs.setUser(user);
        rs.setWs(workStation);
        
        System.out.println(rs);
        reservationRepo.save(rs);
        log.info("Reservation" + rs.getId()+ " saved. ");
        return rs;
    }

    public List<Reservation> findAllReservations() {
        return (List<Reservation>) reservationRepo.findAll();
    }
    
    public Reservation findReservationById(Long id) {
    	System.out.println("Prenotazione trovata!");
    	return reservationRepo.findById(id).get();
    }
    
    public void deleteReservationById(Long id) {
    	System.out.println("Prenotazione eliminata dal database!");
    	reservationRepo.deleteById(id);
    }

    public boolean reserve(LocalDate resDate, User user, WorkStation workStation) {
        List<Reservation> existingUserReservations = reservationRepo.findByUserAndResDate(user, resDate);
        if (!existingUserReservations.isEmpty()) {
            return false;
        }

        List<Reservation> existingReservations = reservationRepo.findByResDateAndWsId(resDate, workStation.getId());
        if (!existingReservations.isEmpty()) {
            return false;
        }

        Reservation reservation = new Reservation();
        reservation.setResDate(resDate);
        WorkStation workspace = getWorkspaceById(workStation.getId());
        reservation.setWs(workspace);
        reservation.setUser(user);
        reservationRepo.save(reservation);
        return true;
    }

    private WorkStation getWorkspaceById(Long workspaceId) {
        Optional<WorkStation> workspaceOpt = reservationRepo.getOne(workspaceId);
        if (workspaceOpt.isEmpty()) {
            throw new IllegalArgumentException("Postazione non trovata con ID: " + workspaceId);
        }
        return workspaceOpt.get();
    }

}
