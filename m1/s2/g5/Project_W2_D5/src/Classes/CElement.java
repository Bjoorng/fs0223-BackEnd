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

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "CElement [isbn=" + isbn + ", title=" + title + ", year=" + year + ", pages=" + pages + "]";
	}

}
