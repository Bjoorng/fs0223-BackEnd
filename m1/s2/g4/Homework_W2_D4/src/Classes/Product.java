package Classes;

public class Product {

	private long id;
	protected String category;
	protected String name;
	protected double price;

	public Product(String category, String name, double price) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", name=" + name + ", price=" + price + "]";
	}
	
}
