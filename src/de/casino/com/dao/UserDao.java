package de.casino.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.casino.com.database.DbManager;
import de.casino.com.database.UserBean;
import de.casino.com.exceptions.UserNotFoundException;

public class UserDao implements DatabaseDao<UserBean>{

	@Override
	public UserBean getSingleItemByValue(String column, UserBean value) {
		String sql="";
		switch (column) {
		case "idUser":
			sql = "Select * from user where idUser= " + value.getIdUser();
			break;
		case "username":
			sql = "Select * from user where username= '" + value.getUsername() + "'";
			break;
		case "email":
			sql = "Select * from user where email= '" + value.getEmail() + "'";
			break;
		default:
			break;
		}
		System.out.println("Creating statement: " + sql);
		Statement stmt = null;
		ResultSet rs = null;
		
		UserBean res = null;
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res = new UserBean(rs.getInt("idUser"),rs.getString("username"), rs.getString("firstname"), rs.getString("lastname"),rs.getString("password"),rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DbManager.closeConnection();
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		if (res==null) {
//			try {
//				throw new UserNotFoundException();
//			} catch (UserNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
		
		return res;
	}

	@Override
	public List<UserBean> getAllItems() {
		
		String sql = "Select * from user";
		
		System.out.println("Creating statement: " + sql);
		Statement stmt;
		ResultSet rs = null;
		
		List<UserBean> allUsers = new ArrayList<UserBean>();
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				allUsers.add(new UserBean(rs.getInt("idUser"),rs.getString("username"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("password"),rs.getString("email")));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allUsers;
	}
	
	@Override
	public boolean createNewItem(UserBean newItem) {
		System.out.println("creating new user: " + newItem);
		
		String insertSql = "insert into user"
				+"(username, firstname, lastname, password, email) values"
				+"(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = DbManager.getConnection().prepareStatement(insertSql);
			preparedStatement.setString(1, newItem.getUsername());
			preparedStatement.setString(2, newItem.getFirstname());
			preparedStatement.setString(3, newItem.getLastname());
			preparedStatement.setString(4, newItem.getPassword());
			preparedStatement.setString(5, newItem.getEmail());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(UserBean item) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
