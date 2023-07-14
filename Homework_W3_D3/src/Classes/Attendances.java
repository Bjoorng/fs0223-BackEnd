package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Enums.Attendance;

@Entity
@Table(name = "attendances")
public class Attendances {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private long id;
	@ManyToOne
	private Person person;
	@OneToOne(mappedBy = "attendance")
	private Event event;
	private Attendance attendanceState;
	
	public Attendances() {
		super();
	}

	public Attendances(Person person, Event event, Attendance attendanceState) {
		super();
		this.person = person;
		this.event = event;
		this.attendanceState = attendanceState;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Attendance getAttendanceState() {
		return attendanceState;
	}

	public void setAttendanceState(Attendance attendanceState) {
		this.attendanceState = attendanceState;
	}

	@Override
	public String toString() {
		return "Attendances [I)=" + getId() + ", Person=" + getPerson() + ", Event=" + getEvent() + "]";
	}

}
