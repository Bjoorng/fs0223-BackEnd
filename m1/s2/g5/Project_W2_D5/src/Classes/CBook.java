package Classes;

import Enums.Genre;

public class CBook extends CElement {

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

	public void setAuthor(String author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "CMagazine [isbn=" + isbn + ", title=" + title + ", year=" + year + ", pages=" + pages + ", author="
				+ author + ", genre=" + genre + "]";
	}

	public static String writeOnFile(CBook book) {
		return CBook.class.getSimpleName()
				+ "/" + book.isbn 
				+ "/" + book.title 
				+ "/" + book.year 
				+ "/" + book.pages 
				+ "/" + book.author 
				+ "/" + book.genre;
	}
	
}
