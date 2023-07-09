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

	public static String writeOnFile(CBook b) {
		return CBook.class.getSimpleName()
				+ "/" + b.isbn 
				+ "/" + b.title 
				+ "/" + b.year 
				+ "/" + b.pages 
				+ "/" + b.author 
				+ "/" + b.genre;
	}
	
	public static CBook fromStringFile(String stringFile) {
		String[] split = stringFile.split("/");
		
		return new CBook(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5], Genre.valueOf(split[6]));
	}
}
