package com.classesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.classes.Magazine;

import Utils.JpaUtils;

public class MagazineDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void save(Magazine m) throws SQLException {
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.refresh(m);
		System.out.println(m);
	}
	
	public Magazine magDetails(long id) throws SQLException {
		em.getTransaction().begin();
		Magazine m = em.find(Magazine.class, id);
		em.getTransaction().commit();
		return m;
	}
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Magazine m = em.find(Magazine.class, id);
		em.remove(m);
		em.getTransaction().commit();
		System.out.println(m.getTitle() + " " + m.getPeriod() + " deleted!!!");
	}
	
}
