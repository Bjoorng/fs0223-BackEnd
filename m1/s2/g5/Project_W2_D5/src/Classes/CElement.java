package Classes;

public abstract class CElement {

	protected String isbn;
	protected String title;
	protected int year;
	protected int pages;
	
	public CElement(String isbn, String title, int year, int pages) {
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getPages() {
		return pages;
	}
	
	@Override
	public String toString() {
		return "CElement [isbn=" + isbn + ", title=" + title + ", year=" + year + ", pages=" + pages + "]";
	}
	
}
