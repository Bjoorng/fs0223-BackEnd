package com.abstractClass;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Element {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isbn;
	private String title;
	private LocalDate publishedIn;
	private int pages;
	
	public Element() {
		super();
	}

	public Element(String isbn, String title, LocalDate publishedIn, int pages) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publishedIn = publishedIn;
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublishedIn() {
		return publishedIn;
	}

	public void setPublishedIn(LocalDate publishedIn) {
		this.publishedIn = publishedIn;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Element [isbn=" + isbn + ", title=" + title + ", publishedIn=" + publishedIn + ", pages=" + pages + "]";
	}

}
