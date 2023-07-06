package MainPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.*;


public class MainClass {
	
	public static Logger log = LoggerFactory.getLogger(MainClass.class);
	
	private static List<Product> productList = new ArrayList<Product>();
	private static List<Product> order1List = new ArrayList<Product>();
	private static List<Product> order2List = new ArrayList<Product>();
	private static List<Product> order3List = new ArrayList<Product>();
	private static List<Product> order4List = new ArrayList<Product>();
	private static List<Order> orderList = new ArrayList<Order>();

	public static void main(String[] args) {
		
		LocalDate orderDate1 =	LocalDate.now();
		LocalDate orderDate2 =	LocalDate.now();
		LocalDate orderDate3 =	LocalDate.now();
		LocalDate orderDate4 =	LocalDate.of(2021,2,10);
		LocalDate deliveryDate1 =	LocalDate.now();
		LocalDate deliveryDate2 =	LocalDate.now();
		LocalDate deliveryDate3 =	LocalDate.now();
		LocalDate deliveryDate4 =	LocalDate.now();
		
		Customer customer1 = new Customer("Mario Rossi", 1);
		Customer customer2 = new Customer("Giuseppe Verdi", 1);
		Customer customer3 = new Customer("Giacomo Neri", 2);
		Customer customer4 = new Customer("Stefano Bianchi", 2);
		
		Product product1 = new Product("Book", "Teaching Of All Ages", 500.00);
		Product product2 = new Product("Book", "Star Wars", 40.00);
		Product product3 = new Product("Book", "Little Women", 2.00);
		Product product4 = new Product("Book", "Frankenstein", 120.50);
		Product product5 = new Product("Boys", "Skateboard", 46.99);
		Product product6 = new Product("Boys", "Guitar", 46.99);
		Product product7 = new Product("Boys", "Marvel Zombies", 46.99);
		Product product8 = new Product("Boys", "God Of War: Ragnarok", 70.99);
		Product product9 = new Product("Baby", "Pacifier", 12.50);
		Product product0 = new Product("Baby", "Ball", 6.00);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		productList.add(product6);
		productList.add(product7);
		productList.add(product8);
		productList.add(product9);
		productList.add(product0);
		
		order1List.add(product0);
		order1List.add(product2);
		order1List.add(product3);
		order1List.add(product5);
		order1List.add(product7);
		
		order2List.add(product3);
		order2List.add(product6);
		order2List.add(product9);
		order2List.add(product2);
		
		order3List.add(product1);
		order3List.add(product2);
		order3List.add(product8);
		order3List.add(product4);
		order3List.add(product5);
		order3List.add(product3);
		
		order4List.add(product2);
		order4List.add(product4);
		order4List.add(product6);
		order4List.add(product3);
		order4List.add(product5);
		order4List.add(product8);
		
		Order order1 = new Order(1, "Ready", orderDate1, deliveryDate1, order1List, customer1);
		Order order2 = new Order(2, "Shipped", orderDate2, deliveryDate2, order2List, customer2);
		Order order3 = new Order(3, "Getting Ready", orderDate3, deliveryDate3, order3List, customer3);
		Order order4 = new Order(4, "Getting Ready", orderDate4, deliveryDate4, order4List, customer4);
		
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		orderList.add(order4);
		
		List<Product> filteredBooks = filterBooks();
		filteredBooks.forEach(e -> log.info("Books Over 100$: " + e.toString()));
		List<Order> filteredOrders = filterOrders();
		filteredOrders.forEach(e -> log.info("Orders Containing Baby Products: " + e.toString()));
		List<Product> discounted = discount();
		discounted.forEach(e -> log.info("These Are The Discounted Products: " + e.toString()));
		List<Order> byClient = filterByClient();
		byClient.forEach(e-> log.info("These Are The Orders: " + e.toString()));
		
	}

	private static List<Product> filterBooks() {
		List<Product> filteredBooks = productList.stream()
				.filter(e -> e.getCategory().equals("Book"))
				.filter(e -> e.getPrice() > 100)
				.collect(Collectors.toList());
		return filteredBooks;
	}
	
	private static List<Order> filterOrders() {
		List<Order> filteredOrders = orderList.stream()
				.filter(e -> e.getProducts().stream()
						.anyMatch(m -> m.getCategory().equals("Baby")))
				.collect(Collectors.toList());
		return filteredOrders;
	}
	
	private static List<Product> discount(){
		List<Product> discounted = productList.stream()
				.filter(e -> e.getCategory().equals("Boys"))
				.map(e -> new Product(e.getCategory(), e.getName(), (e.getPrice()*10)/100))
				.collect(Collectors.toList());
		return discounted;
	}
	
	private static List<Order> filterByClient (){
		LocalDate startDate = LocalDate.of(2021, 02, 1);
		LocalDate endDate = LocalDate.of(2021, 04, 1);
		List<Order> byClient = orderList.stream()
				.filter(e -> e.getCustomer().getTier()== 2)
				.filter(e -> e.getOrderDate().isAfter(startDate) && e.getOrderDate().isBefore(endDate))
				.collect(Collectors.toList());
				return byClient;		
	}
	
}
