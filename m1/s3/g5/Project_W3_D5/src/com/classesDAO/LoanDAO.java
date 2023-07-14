package com.classesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.classes.Loan;

import Utils.JpaUtils;

public class LoanDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void save(Loan l) throws SQLException {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.refresh(l);
		System.out.println(l);
	}
	
	public Loan bookDetails(long id) throws SQLException {
		em.getTransaction().begin();
		Loan l = em.find(Loan.class, id);
		em.getTransaction().commit();
		return l;
	}
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Loan l = em.find(Loan.class, id);
		em.remove(l);
		em.getTransaction().commit();
		System.out.println(l.getUser() + " " + l.getElement() + " deleted!!!");
	}
}
