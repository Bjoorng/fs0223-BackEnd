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

	public static CMagazine fromStringFile(String stringFile) {
		String[] split = stringFile.split("/");
		
		return new CMagazine(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), Periodicity.valueOf(split[5]));
	}
}
