package Classes;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Util.JpaUtil;

public class LocationDAO extends JpaUtil{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void save(Event e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.refresh(e);
		System.out.println(e);
	}
	
	public Event eventDetails(long id) throws SQLException {
		em.getTransaction().begin();
		Event e = em.find(Event.class, id);
		em.getTransaction().commit();
		return e;
	}
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Event e = em.find(Event.class, id);
		em.remove(e);
		em.getTransaction().commit();
		System.out.println(e.getTitle() + " " + e.getEventType() + " deleted!!!");
	}
	
}
