package cn.edu.nju.se.DevOpsProject.service;


import java.util.List;

import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.User;

public class UserQueryService {
	private UserDao userDao;
	
	public List<User> getActiveUsers(){
		return userDao.getActiveUsers();
	}
	
	public List<User> getInactiveUsers(){
		return userDao.getInactiveUsers();
	}

	public User getUserByEmail(String email){
		return userDao.getUserByEmail(email);
	}
	
	public User getUserById(int id){
		return userDao.getUserById(id);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
