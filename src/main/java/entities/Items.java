package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "item.findByISBN", query = "SELECT i FROM Items i WHERE i.ISBN = :isbn")
@NamedQuery(name = "item.findByPublicationDate", query = "SELECT i FROM item i WHERE i.publicationDate = :year")
@NamedQuery(name = "item.findByTitle", query = "SELECT i FROM item i WHERE i.title LIKE :title")
@NamedQuery(name = "loan.findByUserCardNumber", query = "SELECT l.item FROM Loan p WHERE l.user.cardNumber = :cardNumber AND l.returnDate IS NULL")
@NamedQuery(name = "loan.findScadutiNonRestituiti", query = "SELECT p.elemento FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL")

public abstract class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "isbn")
	private long ISBN;

	@Column(nullable = false)
	private String title;

	@Column(name = "publication_date", nullable = false)
	private int publicationDate;

	@Column(name = "page_total", nullable = false)
	private Integer pageTotal;

	public Items() {
		super();
	}

	public Items(String title, int publicationDate, Integer pageTotal) {
		super();
		this.title = title;
		this.publicationDate = publicationDate;
		this.pageTotal = pageTotal;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(int publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	@Override
	public String toString() {
		return "item [codiceISBN=" + ISBN + ", title=" + title + ", publicationDate=" + publicationDate + ", pageTotal="
				+ pageTotal + "]";
	}

}

