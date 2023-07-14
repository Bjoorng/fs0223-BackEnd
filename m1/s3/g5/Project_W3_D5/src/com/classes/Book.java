package com.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.abstractClass.Element;
import com.enums.Genre;

@Entity
public class Book extends Element{
	
	private String author;
	@Enumerated(EnumType.STRING)
	private Genre genre;

	public Book(String isbn, String title, LocalDate publishedIn, int pages, String author, Genre genre) {
		super(isbn, title, publishedIn, pages);
		this.author = author;
		this.genre = genre;
	}

	public Book() {
		super();
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [getAuthor()=" + getAuthor() + ", getGenre()=" + getGenre() + "]";
	}

}
