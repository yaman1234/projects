package project.main;

import java.util.Scanner;

public class Input {
	double amount;
	String date;
	String remarks;
	Scanner scan = new Scanner(System.in);

	public Input() {

		System.out.println("Enter the amount you want to deposite ");
		amount = scan.nextDouble();
		System.out.println("Enter the Date ");
		date = scan.next();
		System.out.println("Enter the Remarks");
		remarks = scan.next();
	}
}