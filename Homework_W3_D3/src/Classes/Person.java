package Classes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import Enums.Gender;

@Entity
@Table(name = "people")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private long id;
	@Column(name = "firstName", nullable = false)
 	private String firstName;
	@Column(name = "lastName", nullable = false)
 	private String lastName;
	@Column(name = "email", nullable = false)
 	private String email;
	@Column(name = "birthdate", nullable = false)
 	private LocalDate birthdate;
	@Enumerated(EnumType.STRING)
	@Column(name = "privacy")
 	private Gender gender;
	@ManyToMany(mappedBy = "people")
	@OrderBy("events")
	private List<Event> events;
	@OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
	private List<Attendances> attendance;

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, String email, LocalDate birthdate, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthdate = birthdate;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Person [id()=" + getId() + ", FirstName()=" + getFirstName() + ", LastName()=" + getLastName()
				+ ", Email()=" + getEmail() + ", Birthdate()=" + getBirthdate() + ", Gender()=" + getGender()
				+ ", Events()=" + getEvents() + "]";
	}
	
}
