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
		System.out.println("Gestione Prenotazione Runner... ");

		Building e1 = edsc.createEdificio("Edificio 1", "Via Roma", "Milano");
		Building e2 = edsc.createEdificio("Edificio 2", "Via Milano", "Roma");

		WorkStation p1 = ps.createWorkStation("Postazione 1", Type.PRIVATE, 1, e1);
		WorkStation p2 = ps.createWorkStation("Postazione 2", Type.MEETING_ROOM , 10, e2);
		WorkStation p3 = ps.createWorkStation("Postazione 3", Type.OPEN_SPACE, 20, e1);

		User u1 = us.createUser("giuseppe_v","Giuseppe Verdi","g.verdi@example.com");
		User u2 = us.createUser("mario_r","Mario Rossi","mario.rossi@example.com");
		User u3 = us.createUser("f_neri","Francesca Neri","francescaneri@example.com");
		User u4 = us.createUser("sara-rosa","Sara Rosa","sara_rosa@example.com");

		Reservation pr1 = prs.createReservation(LocalDate.of(2023, 7, 29), u1, p1);
		Reservation pr2 = prs.createReservation(LocalDate.of(2023, 7, 30), u2, p1);
		Reservation pr3 = prs.createReservation(LocalDate.of(2023, 7, 25), u3, p3);
		

		//List<Edificio> listaEdifici = edsc.findAllEdifici();
		//listaEdifici.forEach(e -> System.out.println(e));
		
		//List<Postazione> listaPostazioni = ps.findAllPostazioni();
		//listaPostazioni.forEach(p -> System.out.println(p));
		
		//List<User> usersList = us.findAllUsers();
		//usersList.forEach(u -> System.out.println(u));
		
		//List<Prenotazione> listaPrenotazioni = prs.findAllPrenotazioni();
		//listaPrenotazioni.forEach(pr -> System.out.println(pr));
		
		// Per eliminare un utente nel db
		//us.deleteUtenteById((long) 4);
		
		// Per trovare un elemento dall'id
		//edsc.findEdificioById((long) 1);

	}	
}
