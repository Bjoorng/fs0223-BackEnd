package MainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.*;

public class CMain {

	private static Logger log = LoggerFactory.getLogger(CMain.class);
	private static Scanner scan = new Scanner(System.in);
	
	private static List<CElement> catalogue = new ArrayList<CElement>();

	public static void main(String[] args) {
		
		addBook();
		addMagazine();
		
	}

	private static void addBook() {
		
	}

	private static void addMagazine() {

	}
}
