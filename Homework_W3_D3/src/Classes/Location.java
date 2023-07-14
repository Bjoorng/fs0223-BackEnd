package Classes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private long id;
	@Column(name = "locationName", nullable = false)
 	private String locationName;
	@Column(name = "city", nullable = false)
 	private String city;
	@OneToMany(mappedBy = "location")
	private List<Event> eventsInLocation;

	public Location() {
		super();
	}

	public Location(String locationName, String city) {
		super();
		this.locationName = locationName;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location [Id=" + getId() + ", LocationName=" + getLocationName() + ", City=" + getCity()
				+ "]";
	}

}
