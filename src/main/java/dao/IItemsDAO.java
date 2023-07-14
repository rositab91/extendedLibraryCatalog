package dao;

import java.util.List;

import entities.Items;

public interface IItemsDAO {

	public void saveItem(Items i);

	public void deleteItem(long i);

	Items searchByISBN(long ISBN);

	List<Items> searchByTitle(String title);

	List<Items> searchByPublicationDate(int publicationDate);

}
