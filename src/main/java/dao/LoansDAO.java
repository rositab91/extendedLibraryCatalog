package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Items;
import entities.Loans;

public class LoansDAO implements ILoansDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("extended_library_category");
	static EntityManager em = emf.createEntityManager();
	
	@Override
	public void saveLoan(Loans u) {
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println("User successfully saved!");
		} catch (Exception ut) {
			em.getTransaction().rollback();
			System.out.println("Error!");
		} finally {
			em.close();
		}
	}
	
	
	@Override
	public List<Items> searchLoanedItems(String userCardNumber) {
		TypedQuery<Items> query = em.createNamedQuery("loans.findByCardNumber", Items.class);
		query.setParameter("cardNumber", userCardNumber);
	    return query.getResultList();
	}

	@Override
	public List<Items> searchExpiredLoans() {
		TypedQuery<Items> query = em.createNamedQuery("loans.findExpired", Items.class);
	    return query.getResultList();
	}

	
}
