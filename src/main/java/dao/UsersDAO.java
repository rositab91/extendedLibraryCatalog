package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Users;

public class UsersDAO implements IUsersDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("extended_library_catalog");
	static EntityManager em = emf.createEntityManager();

	@Override
	public void saveUser(Users u) {
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
}
