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
			System.out.println("Evento salvato nel DB!!");
		} catch (Exception ev) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
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
			System.out.println("Elemento " + i + " eliminato!!");
		} catch (Exception ev) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}			
	}
	
	
		@Override
		public Items searchByISBN(long ISBN) {
			TypedQuery<Items> query = em.createNamedQuery("elemento.findByISBN", Items.class);
			System.out.println("Elemento trovato tramite codice ISBN!!" + "Codice ISBN: " + ISBN);
			query.setParameter("isbn", ISBN);
			List<Items> risultati = query.getResultList();
			for (Items elem : risultati) {
				System.out.println("Titolo del libro: " + elem.getTitle());
	        }
	        
	        return null;
	    }

	    
	    @Override
		public List<Items> searchByTitle(String title) {
			TypedQuery<Items> query = em.createNamedQuery("elemento.findByTitolo", Items.class);
			query.setParameter("titolo", "%" + title + "%");
			List<Items> results = query.getResultList();
	        
			for (Items elem : results) {
				System.out.println("Book Title: " + elem.getTitle());
	        }
	        
			return results;
	    }
	    
		@Override
		public List<Items> searchByPublicationDate(int publicationDate) {
			TypedQuery<Items> query = em.createNamedQuery("elemento.findByPublicationDate", Items.class);
			query.setParameter("year", publicationDate);
			List<Items> titles = query.getResultList();
		    
			return titles;
		}

}
