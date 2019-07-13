package de.casino.com.services;

import java.util.List;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.UserDao;
import de.casino.com.dao.UserLoginDao;
import de.casino.com.database.UserBean;
import de.casino.com.database.UserLoginBean;

public class LoginService {
	
	private DatabaseDao<UserBean> userDao = new UserDao();
	private DatabaseDao<UserLoginBean> loginDao = new UserLoginDao();
	
	public boolean updateUserLogin(UserLoginBean userLogin) {
		return loginDao.createNewItem(userLogin);
	}
	
	public boolean isUserLoginCorrect(UserBean userToCheck) {
		List<UserBean> allUsers = userDao.getAllItems();
		
		for (UserBean user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(userToCheck.getUsername()) && user.getPassword().equals(userToCheck.getPassword())) {
				return true;
			}
		}
		System.out.println("user not authenticated");
		return false;
	}
	
	public boolean registerUser(UserBean userToRegister) {
		return userDao.createNewItem(userToRegister);
	}

	public boolean checkUserSpecifications(UserBean userBean) {
			return (isEmailAvailable(userBean) && isUsernameAvailable(userBean));
	}

	private boolean isEmailAvailable(UserBean userbean) {
			if (userDao.getSingleItemByValue("email", userbean) == null) {
				return true;
			}
			System.out.print("Email: " + userbean.getEmail() + " is already used");
			return false;
	}
	
	private boolean isUsernameAvailable(UserBean userbean) {
		if (userDao.getSingleItemByValue("username", userbean) == null) {
			return true;
		}
			System.out.println("Username: " + userbean.getUsername() + " is already used");
		return false;
	}
}
