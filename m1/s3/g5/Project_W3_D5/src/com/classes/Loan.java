package com.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private User user;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	@ManyToOne
	@JoinColumn(name = "magazine_id")
	private Magazine magazine;
	private LocalDate loanStDate;
	private LocalDate loanEndDate;
	private LocalDate returnDate;
	
	public Loan() {
		super();
	}

	public Loan(User user, Book book, Magazine magazine, LocalDate loanStDate, LocalDate loanEndDate, LocalDate returnDate) {
		super();
		this.user = user;
		this.book = book;
		this.magazine = magazine;
		this.loanStDate = loanStDate;
		this.loanEndDate = loanEndDate;
		this.returnDate = returnDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public LocalDate getLoanStDate() {
		return loanStDate;
	}

	public void setLoanStDate(LocalDate loanStDate) {
		this.loanStDate = loanStDate;
	}

	public LocalDate getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(LocalDate loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public String toStringBook() {
		return "Loan [user=" + user + ", book=" + book + ", loanStDate=" + loanStDate + ", loanEndDate="
				+ loanEndDate + ", returnDate=" + returnDate + "]";
	}
	
	public String toStringMagazine() {
		return "Loan [user=" + user + ", magazine=" + magazine + ", loanStDate=" + loanStDate + ", loanEndDate="
				+ loanEndDate + ", returnDate=" + returnDate + "]";
	}
	
}
