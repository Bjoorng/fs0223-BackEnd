package Classes;

public class Attendance {
	private String name;
	private int attendance;
	public Attendance(String name, int attendance) {
		super();
		this.name = name;
		this.attendance = attendance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
	@Override
	public String toString() {
		return "Attendance [name=" + name +",attendance"+ attendance + "]";
	}
}
