package cn.edu.nju.se.DevOpsProject.service;

import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.User;

public class UserModService {
	private UserDao userDao;
	
	public void addUser(User user){
		userDao.addUser(user);
	}
	
	public void updateUser(User user){
		userDao.updateUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
