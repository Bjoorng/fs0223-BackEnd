package MainPackage;

import java.sql.SQLException;
import java.time.LocalDate;

import Classes.Event;
import Classes.EventDAO;
import Enums.EventType;

public class MainClass {

	public static void main(String[] args) {
		
		Event ev = 
		new Event("Mostra", LocalDate.of(2023, 7, 25), "Mostra D'Arte Contemporanea", EventType.PUBLIC, 500);
		Event ev2 = 
		new Event("Mostra", LocalDate.of(2023, 2, 12), "Mostra Del Cinema", EventType.PRIVATE, 200);
		
		try {
			EventDAO eventDAO = new EventDAO();
			eventDAO.delete(ev);
			eventDAO.delete(ev);
			eventDAO.delete(ev);
			eventDAO.delete(ev);
			eventDAO.delete(ev);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
