package com.epicode.main.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.main.classes.Building;
import com.epicode.main.classes.Reservation;
import com.epicode.main.classes.WorkStation;
import com.epicode.main.enums.Type;
import com.epicode.main.repo.ReservationRepo;
import com.epicode.main.repo.WorkStationRepo;

@Service
public class WorkStationService {

	Logger log = LoggerFactory.getLogger(WorkStationService.class);
	
	@Autowired WorkStationRepo workStationRepo;
    @Autowired ReservationRepo reservationRepo;
    @Autowired @Qualifier("workstation") private ObjectProvider<WorkStation> workStationProvider;
    
    public WorkStation createWorkStation(String description, Type type, Integer seats, Building building) {
    	WorkStation ws = workStationProvider.getObject();
        ws.setDescription(description);
        ws.setType(type);
        ws.setSeats(seats);
        //post.setOccupato(true);
        ws.setBuilding(building);
        workStationRepo.save(ws);
        log.info("WorkStation" + ws.getId() + " saved.");
        return ws;
    }
    
    public List<WorkStation> findAllWorkstations() {
        return (List<WorkStation>) workStationRepo.findAll();
    }
    
    public WorkStation findWorkstationById(Long id) {
    	System.out.println("WorkStation trovata!");
    	return workStationRepo.findById(id).get();
    }
    
    public void deleteWorkstationById(Long id) {
    	System.out.println("Postazione eliminata dal database!");
    	workStationRepo.deleteById(id);
    }
    
    public List<WorkStation> findWorkStationsByTypeAndDate(Type type, LocalDate date) {
        List<WorkStation> wsAll = workStationRepo.findByType(type);
        List<Reservation> resInDate = reservationRepo.findByDate(date);

        for (Reservation res : resInDate) {
            wsAll.remove(res.getWs());
        }

        return wsAll;
    }
}
