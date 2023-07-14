package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "loans")
public class Loans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Users user;

	@ManyToOne
	private Items item;

	@Column(name = "loan_start")
	private LocalDate loanStart;

	@Column(name = "expected_return")
	private LocalDate expectedReturn;

	@Column(name = "return_date")
	private LocalDate returnDate;

	public Loans() {
		super();
	}

	public Loans(Users user, entities.Items item, LocalDate loanStart, LocalDate expectedReturn, LocalDate returnDate) {
		super();
		this.user = user;
		this.item = item;
		this.loanStart = loanStart;
		this.expectedReturn = expectedReturn;
		this.returnDate = returnDate;
	}

	@PrePersist
	private void expectedReturn() {
		if (loanStart != null) {
			expectedReturn = loanStart.plusDays(30);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public LocalDate getLoanStart() {
		return loanStart;
	}

	public void setLoanStart(LocalDate loanStart) {
		this.loanStart = loanStart;
	}

	public LocalDate getExpectedReturn() {
		return expectedReturn;
	}

	public void setExpectedReturn(LocalDate expectedReturn) {
		this.expectedReturn = expectedReturn;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", user=" + user + ", item=" + item + ", loanStart=" + loanStart
				+ ", restituzionePrevista=" + expectedReturn + ", returnDate=" + returnDate + "]";
	}

}
