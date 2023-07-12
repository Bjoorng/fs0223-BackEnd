import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Classes.CStudent;
import DB.DataBase;

public class MainClass {

	public static void main(String[] args) {
		
		CStudent s = new CStudent(1, "Ciro", "Esposito", "male", LocalDate.of(1998,07,21), 8.5, 8.0, 9.0);
		
		try {
		DataBase db = new DataBase();
		db.createTable();
		List<CStudent> list = db.students();
		list.forEach(stud -> System.out.println(stud));
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		
	}

}
