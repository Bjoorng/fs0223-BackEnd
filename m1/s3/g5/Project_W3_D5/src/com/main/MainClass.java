package com.main;

import java.sql.SQLException;
import java.time.LocalDate;

import com.classes.*;
import com.classesDAO.*;
import com.enums.*;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		
		Book b1 = new Book("A02M55", "1984", LocalDate.of(1949, 6, 8), 328, "George Orwell", Genre.SCI_FI);
		Book b2 = new Book("AB567S", "Lord Of The Rings: Te Return Of The King", LocalDate.of(1955, 10, 20),416, "J.R.R. Tolkien", Genre.FANTASY);
		Users u1 = new Users("Mariolino", "Sambucardi", LocalDate.of(1980, 12, 22), "1");
		Loan l1 = new Loan(u1, b2, LocalDate.of(2022, 12, 31), LocalDate.of(2023, 3, 4));
		Loan l2 = new Loan(u1, b1, LocalDate.of(2022, 12, 31), LocalDate.of(2023, 3, 4));
		
		BookDAO bookDAO = new BookDAO();
		UsersDAO usersDAO = new UsersDAO();
		LoanDAO loanDAO = new LoanDAO();
		//bookDAO.saveBook(b1);
		//bookDAO.saveBook(b2);
		//usersDAO.saveUser(u1);
		//bookDAO.searchByIsbn("A02M55");
		//bookDAO.searchBooksByYear(1949);
		//bookDAO.searchByAuthor("George Orwell");
		//bookDAO.searchBooksByYear(1955);
		bookDAO.searchByTitle("Lord");
	}

}
