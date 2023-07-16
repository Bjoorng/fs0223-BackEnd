package com.classes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
    private Users user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate loanStDate;
    private LocalDate loanEndDate;
    private LocalDate returnDate;

    public Loan() {
        super();
    }

    public Loan(Users user, Book book, LocalDate loanStDate, LocalDate loanEndDate) {
        super();
        this.user = user;
        this.book = book;
        this.loanStDate = loanStDate;
        this.loanEndDate = loanEndDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    @Override
    public String toString() {
        return "Loan [user=" + user + ", book=" + book + ", loanStDate=" + loanStDate + ", loanEndDate="
                + loanEndDate + ", returnDate=" + returnDate + "]";
    }
}