package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "card_number", nullable = false)
	private long cardNumber;
	
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	 private List<Loans> loans;
	
	
	public Users() {
		super();
	}

	public Users(String name, String lastName, LocalDate dob) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lastName=" + lastName + ", dob=" + dob + ", cardNumber="
				+ cardNumber + "]";
	}
	
}
