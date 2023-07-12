package DB;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Classes.CStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "Homework_S3_D1_E2";
	String user = "postgres";
	String pass = "root";
	Statement st;

	public DataBase() throws SQLException {
		Connection conn = DriverManager.getConnection(url + dbName, user, pass);
		st = conn.createStatement();
		System.out.println("Connected to DATABASE");
	}

	public void createTable() throws SQLException {
		String sql = " CREATE TABLE IF NOT EXISTS students (" 
				+ "		id SERIAL PRIMARY KEY,"
				+ " 	first_name VARCHAR NOT NULL," 
				+ "		last_name VARCHAR NOT NULL,"
				+ " 	gender VARCHAR NOT NULL," 
				+ "		birthdate DATE NOT NULL,"
				+ "		average DECIMAL NOT NULL," 
				+ "		min_grade DECIMAL NOT NULL,"
				+ "		max_grade DECIMAL NOT NULL" 
				+ " );";
		st.executeUpdate(sql);
		System.out.println("Table utenti created!!!");
	}

	public void createStudent(CStudent s) throws SQLException {
		String sql = " INSERT INTO students (first_name, last_name, gender, birthdate, average, min_grade, max_grade)"
				+ "VALUES ('" 
				+ s.getFirstName() + "','" 
				+ s.getLastName() + "','" 
				+ s.getGender() + "', "
				+ s.getBirthdate() + ",'" 
				+ s.getAverage() + "','" 
				+ s.getMinGrade() + "','" 
				+ s.getMaxGrade() + "');";
		st.executeUpdate(sql);
		System.out.println(s.getFirstName() + " " + s.getLastName() + "student has been created!!!");
	}

	public void deleteStudent(CStudent s) throws SQLException {
		String sql = "DELETE FROM utenti WHERE id = " + s.getId();
		st.executeUpdate(sql);
		System.out.println(s.getFirstName() + " " + s.getLastName() + "student has been deleted!!!");
	}

	public void updateStudent(CStudent s) throws SQLException {
		String sql = "UPDATE students SET " 
					+ " first name = '" + s.getFirstName() + "', " 
					+ " last name = '" + s.getLastName()+ "', " 
					+ " birthdate = '" + s.getBirthdate() + "', "
					+ " gender = '" + s.getGender() + "', "
					+ " average = '" + s.getAverage() + "', "
					+ " min grade = '" + s.getMinGrade() + "', "
					+ " max grade = '" + s.getMaxGrade() + "', "
					+ " WHERE id = "
					+ s.getId();
		st.executeUpdate(sql);
		System.out.println(s.getFirstName() + " " + s.getLastName() + "the student's data has been udpate!!!");
	}

	public List<CStudent> students() throws SQLException {
		String sql = "SELECT * FROM students";
		ResultSet rs = st.executeQuery(sql);
		List<CStudent> studentsList = new ArrayList<CStudent>();
		while (rs.next()) {
			long id = rs.getLong("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			LocalDate birthdate = rs.getDate("birthdate").toLocalDate();
			String gender = rs.getString("gender");
			double average = rs.getDouble("average");
			double minGrade = rs.getDouble("min_vote");
			double maxGrade = rs.getDouble("max_vote");
			CStudent s = new CStudent(id, firstName, lastName, gender, birthdate, average, minGrade, maxGrade);	
			studentsList.add(s);
		}
		return studentsList;
	}
	
	public CStudent maxAverage(List<CStudent> l) throws SQLException {
		String sql = "SELECT *"
					+ "FROM students"
					+ "WHERE average = SELECT(MAX average)"
					+ "FROM students";
		ResultSet rs = st.executeQuery(sql);
		return (CStudent) rs;
	}
	
	public List<CStudent> getGrades(int min, int max) throws SQLException{
		String sql = "SELECT *"
					+ "FROM students"
					+ "WHERE min_grade >= '"+min+"' AND max_grade <= '"+max+"'";
		ResultSet rs = st.executeQuery(sql);
		return  (List<CStudent>) rs;
					
	}
}
