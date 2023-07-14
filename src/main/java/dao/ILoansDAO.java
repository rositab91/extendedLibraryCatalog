package dao;

import java.util.List;

import entities.Items;
import entities.Loans;

public interface ILoansDAO {

	public void saveLoan(Loans u);

	List<Items> searchLoanedItems(String userCardNumber);

	List<Items> searchExpiredLoans();

}
