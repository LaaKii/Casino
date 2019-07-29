package de.casino.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
	
	private static Connection conn = null;
	
	private DbManager() {
		
	}
	
	public static Connection getConnection() {
		
		if (conn==null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				//Standard Server
				//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/casino?serverTimezone=UTC", "root",null);
				//Excel Servier
				conn = DriverManager.getConnection("jdbc:mysql://109.193.93.134:3307/casino?serverTimezone=UTC&useSSL=false", "newuser",null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		
		return conn;

	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UserBean> queryDb(String sql) {
		
		Connection conn = getConnection();
		
		System.out.println("Creating statement: " + sql);
		Statement stmt;
		ResultSet rs = null;
		
		List<UserBean> allUsers = new ArrayList<UserBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				allUsers.add(new UserBean(rs.getString("username"), rs.getString("password")));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allUsers;
	}
	
	public boolean registerUser(UserBean newUser) {
		
		Connection conn = getConnection();
		System.out.println("creating new user: " + newUser);
		
		String insertSql = "insert into user"
				+"(username, firstname, lastname, password, email) values"
				+"(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
			preparedStatement.setString(1, newUser.getUsername());
			preparedStatement.setString(2, newUser.getFirstname());
			preparedStatement.setString(3, newUser.getLastname());
			preparedStatement.setString(4, newUser.getPassword());
			preparedStatement.setString(5, newUser.getEmail());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
