package de.casino.com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import de.casino.com.database.DbManager;
import de.casino.com.database.UserLoginBean;

public class UserLoginDao implements DatabaseDao<UserLoginBean>{

	@Override
	public UserLoginBean getSingleItemByValue(String column, UserLoginBean value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserLoginBean> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createNewItem(UserLoginBean newItem) {
		System.out.println("creating new userLogin: " + newItem);
		
		String insertSql = "insert into userLogin"
				+"(idUser, loginDate) values"
				+"(?,?)";
		
		try {
			PreparedStatement preparedStatement = DbManager.getConnection().prepareStatement(insertSql);
			preparedStatement.setInt(1, newItem.getIdUser());
			preparedStatement.setDate(2, Date.valueOf(newItem.getLoginDate()));
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	
	}

	@Override
	public boolean updateItem(UserLoginBean item) {
		// TODO Auto-generated method stub
		return false;
	}

}
