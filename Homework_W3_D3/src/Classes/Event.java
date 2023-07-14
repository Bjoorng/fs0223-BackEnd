package Classes;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Enums.EventType;

@Entity
@Table(name = "events")

public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private long id;
	@Column(name = "title", nullable = false)
 	private String title;
	@Column(name = "date", nullable = false)
 	private LocalDate eventDate;
	@Column(name = "description", nullable = false)
 	private String description;
	@Enumerated(EnumType.STRING)
	@Column(name = "privacy")
 	private EventType eventType;
	@Column(name = "attendees", nullable = false)
	private int attendees;
	@ManyToOne(cascade = CascadeType.ALL)
 	private Location location;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Person> people;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Attendances attendance;

	public Event() {
		super();
	}

	public Event(String title, LocalDate eventDate, String description, EventType eventType, int attendees,
			Location location) {
		super();
		this.title = title;
		this.eventDate = eventDate;
		this.description = description;
		this.eventType = eventType;
		this.attendees = attendees;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", event date=" + eventDate + ", description=" + description
				+ ", event type=" + eventType + "]";
	}

}
