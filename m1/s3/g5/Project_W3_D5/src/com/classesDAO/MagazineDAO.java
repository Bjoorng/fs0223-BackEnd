package com.classesDAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.classes.Magazine;

import Utils.JpaUtils;

public class MagazineDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void saveMag(Magazine m) throws SQLException {
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
	
	public Magazine searchByIsbn(String isbn) {
		Magazine m = em.createQuery("SELECT m FROM Book m WHERE m.isbn = :isbn", Magazine.class)
		        .setParameter("isbn", isbn)
		        .getSingleResult();
		    
		    System.out.println("The Magazine You're Looking For: " + m.getTitle());
		    
		    return m;
    }
	
	public void searchBooksByYear(int year) {
	    TypedQuery<Magazine> query = em.createQuery("SELECT m FROM Magazine m WHERE YEAR(m.publishedIn) = :year", Magazine.class);
	    query.setParameter("year", year);
	    
	    List<Magazine> mags = query.getResultList();
	    
	    if (mags.isEmpty()) {
	        System.out.println("No Magazines found for the year " + year);
	    } else {
	        System.out.println("Magazines published in the year " + year + ":");
	        for (Magazine mag : mags) {
	            System.out.println("Title: " + mag.getTitle());
	            System.out.println("Published Date: " + mag.getPublishedIn());
	            System.out.println("ISBN: " + mag.getIsbn());
	            System.out.println("---------------------------");
	        }
	    }
	}
	
	public List<Magazine> searchByTitle(String title) {
		TypedQuery<Magazine> query = em.createQuery("SELECT m FROM Book m WHERE m.title LIKE :title", Magazine.class);
		query.setParameter("title", "%" + title + "%");
		List<Magazine> mags = query.getResultList();

		System.out.println("Magazines with title containing: " + title);
		for (Magazine mag : mags) {
			System.out.println(mag.getTitle() + " by " + mag.getPublishedIn());
		}

		return mags;
    }
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Magazine m = em.find(Magazine.class, id);
		em.remove(m);
		em.getTransaction().commit();
		System.out.println(m.getTitle() + " " + m.getPeriod() + " deleted!!!");
	}
	
}
