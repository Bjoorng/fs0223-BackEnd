package MainPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.*;
import Enums.Genre;
import Enums.Periodicity;

public class CMain {

	private static Logger log = LoggerFactory.getLogger(CMain.class);
	private static Scanner scan = new Scanner(System.in);

	private static Map<String, CElement> catalogue = new HashMap<String, CElement>();;

	public static void main(String[] args) {

		
		
		
		//add();
		
	}

	private static void add(CElement e) {
		catalogue.put(e.getIsbn(), e);
		log.info("New Element Added: " + e.toString());
	}
	
	private static void remove(String isbn) {
		CElement e = catalogue.remove(isbn);
		if(e != null) {
			log.info("Element Removed From The Catalogue: " + e.toString());
		}
	}

	private static List<CElement> searchIsbn(Scanner scan) {
		log.info("Write The ISBN Code Of The Item You're Looking For");
		String s = scan.nextLine();
		return catalogue.values().stream()
				.filter(e -> e.getIsbn().equals(s))
				.collect(Collectors.toList());
	}

	private static List<CBook> searchAuthor(Scanner scan) {
		log.info("Write The Author's Full Name Of The Item You're Looking For");
		String s = scan.nextLine();
		return catalogue.values().stream()
				.filter(e -> e instanceof CBook)
				.map(e -> (CBook)e)
				.filter(e -> e.getAuthor().equals(s))
				.collect(Collectors.toList());
	}
	
	private static List<CElement> searchByYear(Scanner scan){
		log.info("Search The Item You Need By Typing The Year It Was Published In");
		int s = Integer.parseInt(scan.nextLine());
		return catalogue.values().stream()
				.filter(e -> e.getYear() == s)
				.distinct()
				.collect(Collectors.toList());
	}
	
	public static void saveOnFile() throws IOException {
		String text = "";
		for(CElement e : catalogue.values()) {
			if(e instanceof CBook) {
				text += CBook.writeOnFile((CBook) e);
			}else if(e instanceof CMagazine) {
				text += CMagazine.writeOnFile((CMagazine) e);
			}
		}
	}
}
