package com.classesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.classes.Book;
import Utils.JpaUtils;

public class BookDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void save(Book b) throws SQLException {
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.refresh(b);
		System.out.println(b);
	}
	
	public Book bookDetails(long id) throws SQLException {
		em.getTransaction().begin();
		Book b = em.find(Book.class, id);
		em.getTransaction().commit();
		return b;
	}
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Book b = em.find(Book.class, id);
		em.remove(b);
		em.getTransaction().commit();
		System.out.println(b.getTitle() + " " + b.getAuthor() + " deleted!!!");
	}
	
}
