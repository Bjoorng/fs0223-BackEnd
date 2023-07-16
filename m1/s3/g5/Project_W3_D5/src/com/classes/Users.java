package com.classes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	@Column(unique = true)
	private String cardNum;
	
	public Users() {
		super();
	}

	public Users(String firstName, String lastName, LocalDate birthdate, String cardNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.cardNum = cardNum;
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
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getCardNum() {
		return cardNum;
	}
	
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate
				+ ", cardNum=" + cardNum + "]";
	}

}
