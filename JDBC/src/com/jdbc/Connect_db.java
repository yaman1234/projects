package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect_db {

	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		read_db();
		create_data();
		read_db();
	}
	
	public static void read_db()throws SQLException, ClassNotFoundException{
		Connection con = Singleton_object.getInstance();
		Statement stmt = con.createStatement();
		String sql = "select * from user";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			System.out.println(rs.getInt("id") +" " +rs.getString("name") +" " +rs.getString("email") +" " +rs.getString("password") );
		}
		System.out.println(con);
	}
	
	public static void create_data() {
		try {
			Connection con = Singleton_object.getInstance();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO `user` (`id`, `name`, `email`, `password`, `operation`) VALUES (NULL, 'test', 'test@gmail.com', '12345', '')";
		stmt.executeUpdate(sql);
		System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
