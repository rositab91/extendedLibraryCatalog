package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import utils.Periodicity;

@Entity
@Table(name = "magazines")
public class Magazines extends Items {
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Periodicity periodicity;
	
	

	public Magazines() {
		super();
	}

	public Magazines(Periodicity periodicity) {
		super();
		this.periodicity = periodicity;
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Magazine [periodicity=" + periodicity + "]";
	}
	
}

