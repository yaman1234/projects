package project.main;

import java.util.Scanner;

public class Tracker {
	private static double balance;

	public static void main(String[] args) {
		display();
		acceptInput();
	}

	public static void display() {
		System.out.println("------------------------------");
		System.out.println("INCOME EXPENSE TRACKER");
		System.out.println("------------------------------");
		System.out.println("");
		System.out.println("What do you want to do today?");
		System.out.println("[1] Check Balance");
		System.out.println("[2] Deposite");
		System.out.println("[3] Withdraw");
		System.out.println("[0] Quit");
		System.out.println("");
		System.out.println("------------------------------");

	}

	public static void acceptInput() {
		System.out.println("------------------------------");
		System.out.println("Enter any option");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		switch (input) {
		case 0:
			System.exit(0);
			break;
		case 1:
			checkBalance();
			break;
		case 2:
			deposite();
			break;
		case 3:
			withdraw();
			break;
		default:
			System.out.println("Please choose valid option");
		}
		display();
		acceptInput();

	}

	public static void deposite() {
		System.out.println("Enter the amount you want to deposite");
		Scanner scan = new Scanner(System.in);
		double deposite_amount = scan.nextDouble();
		balance = balance + deposite_amount;
		System.out.println("Deposite successful");
		System.out.println("Please check the balance to confirm");
	}

	public static void withdraw() {
		System.out.println("Enter the amount you want to withdraw");
		Scanner scan = new Scanner(System.in);
		double withdraw_amount = scan.nextDouble();

		if (balance < withdraw_amount) {
			System.out.println("Cannot complete operation due to ");
			System.out.println("-----Insufficient Balance------- ");
		}

		balance = balance - withdraw_amount;
		System.out.println("Deposite successful");
		System.out.println("Please check the balance to confirm");
	}

	public static void checkBalance() {
		System.out.println("Current balance : Rs." + balance);
	}

	public static void uncalledMethod() {

	}

}
