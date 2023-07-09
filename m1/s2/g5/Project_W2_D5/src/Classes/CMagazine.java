package Classes;

import Enums.Periodicity;

public class CMagazine extends CElement {

	protected String isbn;
	protected String title;
	protected int year;
	protected int pages;
	protected Periodicity periodicity;

	public CMagazine(String isbn, String title, int year, int pages, Periodicity periodicity) {
		super(isbn, title, year, pages);
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
		return "CMagazine [isbn=" + isbn + ", title=" + title + ", year=" + year + ", pages=" + pages + "]";
	}
	
	public static String writeOnFile(CMagazine mag) {
		return CBook.class.getSimpleName()
				+ "/" + mag.isbn 
				+ "/" + mag.title 
				+ "/" + mag.year 
				+ "/" + mag.pages 
				+ "/" + mag.periodicity;
	}

}
