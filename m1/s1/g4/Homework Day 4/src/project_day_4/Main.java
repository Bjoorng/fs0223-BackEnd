package project_day_4;

import project_day_4.Classes.Employee;
import project_day_4.Enums.Department;
import project_day_4.Enums.Level;

public class Main {

	public static void main(String[] args) {
		
		Employee e = new Employee("X4V66", Department.PRODUZIONE);
		Employee e2 = new Employee("YH66R", Department.PRODUZIONE);
		Employee e3 = new Employee("M987O", 1000, 1500, 30, Level.IMPIEGATO, Department.AMMINISTRAZIONE);
		Employee e4 = new Employee("YH7HZ", 1000, 2000, 100, Level.DIRIGENTE, Department.VENDITE);
		
		promotion(e2);
		promotion(e3);
		printData(e);
		printData(e2);
		printData(e3);
		printData(e4);
		
		getExpenses(e,e2,e3,e4);
	}

	private static void promotion(Employee r) {
		r.promote(r);
	}

	private static void printData(Employee r) {
		r.printData(r);
	}
	
	private static void getExpenses(Employee r, Employee r2, Employee r3, Employee r4) {
		double money = Employee.payExtra(r, 5)
				+ Employee.payExtra(r2, 5)
				+ Employee.payExtra(r3, 5)
				+ Employee.payExtra(r4, 5);
		System.out.println(money);
	}
}
