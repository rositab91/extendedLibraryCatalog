package main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IItemsDAO;
import dao.ILoansDAO;
import dao.IUsersDAO;
import dao.ItemsDAO;
import dao.LoansDAO;
import dao.UsersDAO;
import entities.Books;
import entities.Items;
import entities.Loans;
import entities.Magazines;
import entities.Users;
import utils.Periodicity;

public class Main {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("extended_library_catalog");
	static EntityManager em = emf.createEntityManager();


	public static void main(String[] args) {

		try {

			IItemsDAO id = new ItemsDAO();
			IUsersDAO ud = new UsersDAO();
			ILoansDAO loan = new LoansDAO();

			Books bAlfa = new Books();
			bAlfa.setPublicationDate(2023);
			bAlfa.setAuthor("Rebecca Yarros");
			bAlfa.setGenre("Fantasy");
			bAlfa.setPageTotal(528);
			bAlfa.setTitle("Fourth Wing");

			Books bBeta = new Books();
			bBeta.setPublicationDate(2008);
			bBeta.setAuthor("Stephen King");
			bBeta.setGenre("Horror");
			bBeta.setPageTotal(674);
			bBeta.setTitle("The Shining");

			Magazines magaz = new Magazines();
			magaz.setPublicationDate(2022);
			magaz.setPageTotal(100);
			magaz.setPeriodicity(Periodicity.MONTHLY);
			magaz.setTitle("Focus");

			int searchYear = 2022;
			List<Items> publishedTitles = id.searchByPublicationDate(searchYear);

			System.out.println("Titles published in the year " + searchYear + ":");
			for (Items book : publishedTitles) {
				System.out.println(book.getTitle());
			}

			Users uAlfa = new Users();
			uAlfa.setLastName("Liparota");
			uAlfa.setName("Miriam");
			uAlfa.setDob(LocalDate.of(1993, 7, 10));


			Loans lAlfa = new Loans();
			lAlfa.setUser(uAlfa);
			lAlfa.setItem(magaz);
			lAlfa.setLoanStart(LocalDate.of(2023, 4, 5));
			lAlfa.setExpectedReturn(LocalDate.of(2023, 4, 29));
			lAlfa.setReturnDate(LocalDate.of(2023, 5, 10));

			loan.searchLoanedItems(null);

		} catch (Exception e) {
			System.out.println("ERROR! " + e);
		} finally {
			emf.close();
			em.close();
		}

	}
}
