package MainPackage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.*;
import Enums.Genre;
import Enums.Periodicity;

public class CMain {

	private static Logger log = LoggerFactory.getLogger(CMain.class);
	private static HashMap<String, CElement> dataBase;
	private static final String FILE_PATH = "c:\\all\\epicode\\fs0223-Luca-Sernicola-BackEnd\\m1\\s2\\g5\\catalogue.txt";


	public static void main(String[] args) {
	}

	private static void add(CElement e) {
		dataBase.put(e.getIsbn(), e);
		log.info("New Element Added: " + e.toString());
	}
	
	private static void remove(String s) {
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
	
	public static void save() throws IOException {
		String text = "";
		for(CElement e : dataBase.values()) {
			if(e instanceof CBook) {
				text += CBook.writeOnFile((CBook) e);
			}else if(e instanceof CMagazine) {
				text += CMagazine.writeOnFile((CMagazine) e);
			}
		}
	}
	
	public static void load() throws IOException {
	    dataBase.clear();

	    File file = new File(FILE_PATH);
	    String fileString = FileUtils.readFileToString(file, "UTF-8");
	    List<String> splitElementiString = Arrays.asList(fileString.split("#"));

	    for (String curString : splitElementiString) {
	        CElement e = null;
	        if (curString.startsWith(CBook.class.getSimpleName())) {
	            e = CBook.fromStringFile(curString);
	        } else if (curString.startsWith(CMagazine.class.getSimpleName())) {
	            e = CMagazine.fromStringFile(curString);
	        }
	        dataBase.put(e.getIsbn(), e);
	    }
	    
	    log.info("Data From File: " + FILE_PATH);
	}
}
