package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books extends Items {

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private String genre;

	public Books() {
		super();
	}

	public Books(String author, String genre) {
		super();
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", genre=" + genre + "]";
	}
}
