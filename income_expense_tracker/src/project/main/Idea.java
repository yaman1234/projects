package project.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Idea {

	public static void main(String[] args) {
		deposite();
	}

	public static void input() {

	}

	public static void deposite() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement stmt = con.createStatement();

			Input inputObj = new Input();
//			query to get the last row
			String query = ("SELECT * FROM tracker_db ORDER BY balance DESC LIMIT 1;");

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

}
