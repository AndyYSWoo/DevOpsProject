package cn.edu.nju.se.DevOpsProject.service;

import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.User;

public class UserQueryService {
	private UserDao userDao;

	public User getUserByEmail(String email){
		return userDao.getUserByEmail(email);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
