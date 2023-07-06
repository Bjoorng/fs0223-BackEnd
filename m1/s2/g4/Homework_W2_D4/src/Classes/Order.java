package Classes;

import java.time.LocalDate;
import java.util.List;

public class Order {

	protected long id;
	protected String status;
	protected LocalDate orderDate;
	protected LocalDate deliveryDate;
	protected List<Product> products;
	protected Customer customer;

	public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
			Customer customer) {
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", products=" + products + ", customer=" + customer + "]";
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public Customer getCustomer() {
		return customer;
	}


	
}
