package de.casino.com.services;

import java.util.List;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.UserDao;
import de.casino.com.database.UserBean;

public class LoginService {
	
	DatabaseDao<UserBean> userDao = new UserDao();
	
	public boolean isUserLoginCorrect(UserBean userToCheck) {
		List<UserBean> allUsers = userDao.getAllItems();
		
		for (UserBean user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(userToCheck.getUsername()) && user.getPassword().equals(userToCheck.getPassword())) {
				System.out.println("user authenticated");
				return true;
			}
		}
		System.out.println("user not authenticated");
		return false;
	}
	
	public boolean registerUser(UserBean userToRegister) {
		return userDao.createNewItem(userToRegister);
	}

}
