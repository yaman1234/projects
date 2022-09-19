package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton_object {

	// create an object of SingleObject
	private static Singleton_object instance = new Singleton_object();

	// make the constructor private so that this class cannot be instantiated
	private Singleton_object() {
	}

	// Get the only object available
	public static Connection getInstance() throws ClassNotFoundException, SQLException {

		if (instance == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			
		}else {
			
		}
			
		return con;
	}

}
