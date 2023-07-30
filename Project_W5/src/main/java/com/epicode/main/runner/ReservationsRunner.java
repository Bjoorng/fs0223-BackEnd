package com.epicode.main.runner;

import java.time.LocalDate;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epicode.main.classes.Building;
import com.epicode.main.classes.Reservation;
import com.epicode.main.classes.User;
import com.epicode.main.classes.WorkStation;
import com.epicode.main.enums.Type;
import com.epicode.main.service.BuildingService;
import com.epicode.main.service.ReservationService;
import com.epicode.main.service.UserService;
import com.epicode.main.service.WorkStationService;

@Component
public class ReservationsRunner {

	@Autowired BuildingService edsc;
	@Autowired WorkStationService ps;
	@Autowired UserService us;
	@Autowired ReservationService prs;
	
	public void run(String... args) throws Exception {
		System.out.println("runner... ");

		Building b1 = edsc.createEdificio("B 1", "Via combinazione", "Milano");
		Building b2 = edsc.createEdificio("B 2", "Via coordinata", "Roma");
		Building b3 = edsc.createEdificio("B 3", "Via coordinata", "Roma");
		Building b4 = edsc.createEdificio("B 4", "Via coordinata", "Roma");

		WorkStation ws1 = ps.createWorkStation("P 1", Type.PRIVATE, 1, b1);
		WorkStation ws2 = ps.createWorkStation("P 2", Type.MEETING_ROOM , 10, b2);
		WorkStation ws3 = ps.createWorkStation("P 3", Type.OPEN_SPACE, 20, b1);

		User u1 = us.createUser("PeppeTheKing","Giuseppe Verdi","g.verdi@mail.com");
		User u2 = us.createUser("ComboDoubleBoi","Mario Rossi","m.rossi@mail.com");
		User u3 = us.createUser("MiSparoGiuro","Federica Meri","nomecognome@tiscali.com");
		User u4 = us.createUser("Depre-4-Real","Maria Rosa","comesifa@hotmail.com");

		Reservation res1 = prs.createReservation(LocalDate.of(2023, 7, 29), u1, ws1);
		Reservation res2 = prs.createReservation(LocalDate.of(2023, 7, 30), u2, ws1);
		Reservation res3 = prs.createReservation(LocalDate.of(2023, 7, 25), u3, ws3);
 
	}	
}
