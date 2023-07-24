package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Items;

public class ItemsDAO implements IItemsDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("extended_library_catalog");
	static EntityManager em = emf.createEntityManager();

	@Override
	public void saveItem(Items i) {
		try {
			em.getTransaction().begin();
			em.persist(i);
			em.getTransaction().commit();
			System.out.println("Event successfully saved!");
		} catch (Exception ev) {
			em.getTransaction().rollback();
			System.out.println("Error!");
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteItem(long i) {
		try {
			em.getTransaction().begin();
			Items el = em.find(Items.class, i);
			em.remove(el);
			em.getTransaction().commit();
			System.out.println("Item " + i + " deleted!");
		} catch (Exception ev) {
			em.getTransaction().rollback();
			System.out.println("Error!");
		} finally {
			em.close();
		}			
	}
	
	
		@Override
		public Items searchByISBN(long ISBN) {
			TypedQuery<Items> query = em.createNamedQuery("item.findByISBN", Items.class);
			System.out.println("Item found by ISBN!!" + "Code ISBN: " + ISBN);
			query.setParameter("isbn", ISBN);
			List<Items> results = query.getResultList();
			for (Items item : results) {
				System.out.println("Book title: " + item.getTitle());
	        }
	        
	        return null;
	    }

	    
	    @Override
		public List<Items> searchByTitle(String title) {
			TypedQuery<Items> query = em.createNamedQuery("item.findByTitle", Items.class);
			query.setParameter("title", "%" + title + "%");
			List<Items> results = query.getResultList();
	        
			for (Items elem : results) {
				System.out.println("Book title: " + elem.getTitle());
	        }
	        
			return results;
	    }
	    
		@Override
		public List<Items> searchByPublicationDate(int publicationDate) {
			TypedQuery<Items> query = em.createNamedQuery("item.findByPublicationDate", Items.class);
			query.setParameter("year", publicationDate);
			List<Items> titles = query.getResultList();
		    
			return titles;
		}

}
