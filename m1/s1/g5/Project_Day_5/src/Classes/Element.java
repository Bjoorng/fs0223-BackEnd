package Classes;

public abstract class Element {
	
	protected String title;

	public Element(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public abstract void play();
}
