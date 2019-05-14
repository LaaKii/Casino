package de.casino.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.casino.com.login.User;

public class DbManager {
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/casino?serverTimezone=UTC", "root",null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
	
	public List<User> queryDb(String sql) {
		
		Connection conn = getConnection();
		
		System.out.println("Creating statement...");
		Statement stmt;
		ResultSet rs = null;
		
		List<User> allUsers = new ArrayList<User>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				allUsers.add(new User(rs.getString("username"), rs.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

}