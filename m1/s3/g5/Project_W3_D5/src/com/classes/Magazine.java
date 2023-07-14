package com.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.abstractClass.Element;
import com.enums.Periodicity;

@Entity
public class Magazine extends Element{
	
	private long id;
	@Enumerated(EnumType.STRING)
	private Periodicity period;

	public Magazine() {
		super();
	}

	public Magazine(String isbn, String title, LocalDate publishedIn, int pages, Periodicity period) {
		super(isbn, title, publishedIn, pages);
		this.period = period;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Periodicity getPeriod() {
		return period;
	}

	public void setPeriod(Periodicity period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Magazine [period=" + period + "]";
	}
	
}
