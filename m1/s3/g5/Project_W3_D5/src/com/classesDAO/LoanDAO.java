package com.classesDAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.classes.Loan;

import Utils.JpaUtils;

public class LoanDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void saveLoan(Loan l) throws SQLException {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.refresh(l);
		System.out.println(l);
	}
	
	public Loan loanDetails(long id) throws SQLException {
		em.getTransaction().begin();
		Loan l = em.find(Loan.class, id);
		em.getTransaction().commit();
		return l;
	}

	
	 public List<Loan> searchLoansByCardNumber(String cardNumber) {
	        TypedQuery<Loan> query = em.createQuery(
	            "SELECT l FROM Loan l WHERE l.user.cardNumber = :cardNumber", Loan.class);
	        query.setParameter("cardNumber", cardNumber);
	        return query.getResultList();
	    }
	
	public void delete(long id) throws SQLException {
		em.getTransaction().begin();
		Loan l = em.find(Loan.class, id);
		em.remove(l);
		em.getTransaction().commit();
		System.out.println(l.getId() + " " +l.getUser() + " deleted!!!");
	}
	
	public List<Loan> searchOverdueLoans() {
		TypedQuery<Loan> query = em.createQuery(
            "SELECT l FROM Loan l WHERE l.returnDate IS NULL AND l.dueDate < CURRENT_DATE", Loan.class);
        return query.getResultList();
    }
}
