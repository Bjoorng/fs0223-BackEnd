package MainPackage;

import java.sql.SQLException;
import java.time.LocalDate;

import Classes.Event;
import Classes.EventDAO;
import Classes.Location;
import Enums.EventType;

public class MainClass {

	public static void main(String[] args) {
		
		Location l = new Location("Babuciaga", "Eboli");
		Event ev = 
		new Event("Mostra", LocalDate.of(2023, 7, 25), "Mostra D'Arte Contemporanea", EventType.PUBLIC, 500, l);
		Event ev2 = 
		new Event("Mostra", LocalDate.of(2023, 2, 12), "Mostra Del Cinema", EventType.PRIVATE, 200, l);
		
		try {
			EventDAO eventDAO = new EventDAO();
			eventDAO.save(ev);
			eventDAO.save(ev2);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
