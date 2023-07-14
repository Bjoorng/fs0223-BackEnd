package com.classesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.classes.User;

import Utils.JpaUtils;

public class UserDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void save(User u) throws SQLException {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.refresh(u);
		System.out.println(u);
	}
	
	public User bookDetails(long id) throws SQLException {
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		em.remove(u);
		em.getTransaction().commit();
		System.out.println(u.getCardNum() + " " + u.getFirstName() + " " + u.getLastName() + " deleted!!!");
	}
	
}
