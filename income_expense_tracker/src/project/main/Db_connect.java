package project.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connect {

	
	public static Connection getInstance() throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");
		
		return con;
	}
	
}
