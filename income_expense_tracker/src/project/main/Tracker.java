package project.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Tracker {
	private static double balance;
	private static double amount;
	static Scanner scan = new Scanner(System.in);

	Db_connect dbObj = new Db_connect();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		display();
		acceptInput();
	}

	public static void display() {
		System.out.println("------------------------------");
		System.out.println("INCOME EXPENSE TRACKER");
		System.out.println("");
		System.out.println("What do you want to do today?");
		System.out.println("[1] Check Balance");
		System.out.println("[2] Deposite");
		System.out.println("[3] Withdraw");
		System.out.println("[0] Quit");

	}

	public static void acceptInput() throws ClassNotFoundException, SQLException {
		System.out.println("------------------------------");

		System.out.println("Enter any option");

		scan = new Scanner(System.in);
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
		System.out.println("");
		acceptInput();

	}

	public static void deposite() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement stmt = con.createStatement();

			Input inputObj = new Input();
//			query to get the last row
			String query = ("SELECT * FROM tracker_db ORDER BY id DESC LIMIT 1;");

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			double balance = rs.getDouble("balance");

			String sql = "INSERT INTO tracker_db (balance, amount, date, remarks) VALUES ( "
					+ (balance + inputObj.amount) + "," + inputObj.amount + " ,'" + inputObj.date + "' , '"
					+ inputObj.remarks + "' )";
			stmt.executeUpdate(sql);

			System.out.println("Amount deposited");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Amount deposite failed");
		}

	}

	public static void withdraw() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement stmt = con.createStatement();

			Input inputObj = new Input();
//			query to get the last row
			String query = ("SELECT * FROM tracker_db ORDER BY id DESC LIMIT 1;");

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			double balance = rs.getDouble("balance");

			if (balance < inputObj.amount) {
				System.out.println("Cannot complete operation due to ");
				System.out.println("-----Insufficient Balance------- ");
				System.exit(0);
			}

			String sql = "INSERT INTO tracker_db (balance, amount, date, remarks) VALUES ( "
					+ (balance - inputObj.amount) + "," + inputObj.amount + " ,'" + inputObj.date + "' , '"
					+ inputObj.remarks + "' )";
			stmt.executeUpdate(sql);

			System.out.println("Amount withdrawn");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Amount withdraw failed");
		}

	}

	public static void checkBalance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement stmt = con.createStatement();

//		query to get the last row
			String query = ("SELECT * FROM tracker_db ORDER BY id DESC LIMIT 1;");

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			double balance = rs.getDouble("balance");

			System.out.println("current balance :" + balance);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Balance check failed");
		}
	}

	public static Connection db_connect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			return con;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
