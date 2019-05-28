package de.casino.com.services;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.UserDao;
import de.casino.com.database.UserBean;

public class UserService {
	
	private DatabaseDao<UserBean> userDao = new UserDao();
	
	public UserBean getUserByUsername(String username) {
		UserBean tempBean = new UserBean();
		tempBean.setUsername(username);
		return userDao.getSingleItemByValue("username", tempBean);
	}

}
