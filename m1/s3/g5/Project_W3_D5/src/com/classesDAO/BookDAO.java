package com.classesDAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.classes.Book;

import Utils.JpaUtils;

public class BookDAO extends JpaUtils {

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public void saveBook(Book b) throws SQLException {
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.refresh(b);
		System.out.println(b);
	}

	public Book searchByIsbn(String isbn) {
		Book b = em.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class).setParameter("isbn", isbn)
				.getSingleResult();

		System.out.println("The Book You're Looking For: " + b.getTitle());

		return b;
	}

	public void searchBooksByYear(int year) {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE YEAR(b.publishedIn) = :year", Book.class);
		query.setParameter("year", year);

		List<Book> books = query.getResultList();

		if (books.isEmpty()) {
			System.out.println("No books found for the year " + year);
		} else {
			System.out.println("Books published in the year " + year + ":");
			for (Book book : books) {
				System.out.println("Title: " + book.getTitle());
				System.out.println("Author: " + book.getAuthor());
				System.out.println("Published Date: " + book.getPublishedIn());
				System.out.println("ISBN: " + book.getIsbn());
				System.out.println("---------------------------");
			}
		}
	}

	public List<Book> searchByAuthor(String author) {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class);
		query.setParameter("author", "%" + author + "%");
		List<Book> books = query.getResultList();

		System.out.println("Books by author: " + author);
		for (Book book : books) {
			System.out.println(book.getTitle() + " by " + book.getAuthor());
		}

		return books;
	}

	public List<Book> searchByTitle(String title) {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title", Book.class);
		query.setParameter("title", "%" + title + "%");
		List<Book> books = query.getResultList();

		System.out.println("Books with title containing: " + title);
		for (Book book : books) {
			System.out.println(book.getTitle() + " by " + book.getAuthor());
		}

		return books;
	}

	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Book b = em.find(Book.class, id);
		em.remove(b);
		em.getTransaction().commit();
		System.out.println(b.getTitle() + " " + b.getAuthor() + " deleted!!!");
	}

}
