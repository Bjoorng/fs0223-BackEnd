package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.Attendance;
import Thread.*;
public class MainClass {
	
	private static Logger log = LoggerFactory.getLogger(MainClass.class);
	private static File file = new File("documents/attendance.txt");
	private static List<Attendance> attendanceList = new ArrayList<Attendance>();
	
	public static void main(String[] args) throws InterruptedException {
		
		//Esercizio 1
		
		TestThread t1 = new TestThread("£");
		TestThread t2 = new TestThread("#");
		t1.start();
		t2.start();
		
		//Esercizio 2
		
		int[] arr = generateArr(3000);
		int[] arrSum = new int[3];
		
		ThreadArr1 tArr1 = new ThreadArr1(arr, 0, 1000);
		ThreadArr1 tArr2 = new ThreadArr1(arr, 1000, 2000);
		ThreadArr1 tArr3 = new ThreadArr1(arr, 2000, 3000);
		
		tArr1.start();
		tArr1.join();
		tArr2.start();
		tArr2.join();
		tArr3.start();
		tArr3.join();
		
		arrSum[0] = tArr1.getSum();
		arrSum[1] = tArr2.getSum();
		arrSum[2] = tArr3.getSum();
		
		sumArrs(arrSum);
		
		try {
			create();
			saveOnFile();
			attendanceList = loadFromFile();
			for (Attendance a : attendanceList) {
				log.info(a.toString());
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			log.error("Empty File");
		}
	}
	
	public static int[] generateArr(int length) {
		int[] array = new int[length];
		Random random = new Random();
		
		for (int i = 0; i < length; i++) {
			array[i] = random.nextInt(301);
		}
		return array;
	}
	
	public static int sumArrs(int[] array) {
		int sum = 0;
		for(int num : array) {
			sum += num;
		}
		log.info("Sum Of All The Arrays: " + sum);
		return sum;
	}
	
	public static void create() {
		Attendance a1 = new Attendance("Mario Rossi",4);
		Attendance a2 = new Attendance("Giuseppe Verdi",7);
		Attendance a3 = new Attendance("Antonio Bianchi",2);
		
		attendanceList.add(a1);
		attendanceList.add(a2);
		attendanceList.add(a3);
	}
	
	public static void addPeople() {
		try {
			attendanceList = loadFromFile();
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			log.error(e.getMessage());
		}
	}
	
	private static void saveOnFile() throws IOException {
		String txt = "";
		for (Attendance a : attendanceList) {
			txt += a.getName() + "@" + a.getAttendance() + "#";
		}
		FileUtils.writeStringToFile(file, txt, "UTF-8", true);
		log.info("Text Written On File" + file.getPath());
	}

	private static List<Attendance> loadFromFile() throws IOException{
		attendanceList.clear();
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		System.out.println(textFile);
		String[] p = textFile.split("#");
		for(String s : p) {
			String[] par = s.split("#");
			Attendance person = new Attendance(par[0], Integer.parseInt(par[1]));
			attendanceList.add(person);
		}
		return attendanceList;
	}
}
