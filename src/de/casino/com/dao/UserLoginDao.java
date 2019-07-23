package de.casino.com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import de.casino.com.database.DbManager;
import de.casino.com.database.GameBean;
import de.casino.com.database.UserLoginBean;
import de.casino.com.exceptions.GameNotFoundException;
import de.casino.com.exceptions.LoginNotFoundException;

public class UserLoginDao implements DatabaseDao<UserLoginBean>{

	@Override
	public UserLoginBean getSingleItemByValue(String column, UserLoginBean value) {
		String sql="";
		switch (column) {
		case "idUser":
			sql = "Select * from userLogin where idUser=" + value.getIdUser() + " order by idUserLogin desc LIMIT 1,1;";
			break;
		default:
			break;
		}
		
		System.out.println("Creating statement: " + sql);
		Statement stmt = null;
		ResultSet rs = null;
		
		UserLoginBean res = null;
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				res = new UserLoginBean(rs.getInt(1),rs.getInt(2), rs.getDate("loginDate"));
			}else {
				//Default -1 day if user never logged in
				System.out.println("Adding default login date: today - 1");
				res = new UserLoginBean(0,0,Date.valueOf(LocalDate.now().minusDays(1)));
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
		
		if (res==null) {
			try {
				throw new LoginNotFoundException();
			} catch (LoginNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Last Login: " + res);
		return res;
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
