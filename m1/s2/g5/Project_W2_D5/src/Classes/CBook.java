
package Classes;

import Enums.Genre;

public class CBook extends CElement{

	protected String isbn;
	protected String title;
	protected int year;
	protected int pages;
	protected String author;
	protected Genre genre;

	public CBook(String isbn, String title, int year, int pages, String author, Genre genre) {
		super(isbn, title, year, pages);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public Genre getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "CMagazine [isbn=" + isbn + ", title=" + title + ", year=" + year + ", pages=" + pages + ", author="
				+ author + ", genre=" + genre + "]";
	}

}
