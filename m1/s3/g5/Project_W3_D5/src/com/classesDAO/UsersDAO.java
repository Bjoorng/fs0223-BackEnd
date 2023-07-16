package com.classesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.classes.Users;

import Utils.JpaUtils;

public class UsersDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void saveUser(Users u) throws SQLException {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.refresh(u);
		System.out.println(u);
	}
	
	public Users userDetails(long id) throws SQLException {
		em.getTransaction().begin();
		Users u = em.find(Users.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Users u = em.find(Users.class, id);
		em.remove(u);
		em.getTransaction().commit();
		System.out.println(u.getCardNum() + " " + u.getFirstName() + " " + u.getLastName() + " deleted!!!");
	}
	
}
