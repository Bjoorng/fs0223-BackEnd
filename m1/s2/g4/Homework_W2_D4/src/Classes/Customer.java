package Classes;

public class Customer {

	private long id;
	protected String name;
	protected int tier;

	public Customer(String name, int tier) {
		super();
		this.name = name;
		this.tier = tier;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTier() {
		return tier;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", tier=" + tier + "]";
	}
	
}
