package Classes;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CCatalogue {
	
	private static Logger log = LoggerFactory.getLogger(CCatalogue.class);
	
	private static HashMap<String, CElement> dataBase;

	private static void addInDb(CElement e) {
		dataBase.put(e.getIsbn(), e);
		log.info("New Element Added: " + e.toString());
	}
	
	private static void removeFromDb(String s) {
		CElement e = dataBase.remove(s);
		if(e != null) {
			log.info("Element Removed From The Catalogue: " + e.toString());
		}
	}

	private static List<CElement> searchIsbn(String s) {
		log.info("Write The ISBN Code Of The Item You're Looking For");
		return dataBase.values().stream()
				.filter(e -> e.getIsbn().equals(s))
				.collect(Collectors.toList());
	}

	private static List<CBook> searchAuthor(String s) {
		log.info("Write The Author's Full Name Of The Item You're Looking For");
		return dataBase.values().stream()
				.filter(e -> e instanceof CBook)
				.map(e -> (CBook)e)
				.filter(e -> e.getAuthor().equals(s))
				.collect(Collectors.toList());
	}
	
	private static List<CElement> searchByYear(int y){
		log.info("Search The Item You Need By Typing The Year It Was Published In");
		return dataBase.values().stream()
				.filter(e -> e.getYear() == y)
				.distinct()
				.collect(Collectors.toList());
	}
	
}
