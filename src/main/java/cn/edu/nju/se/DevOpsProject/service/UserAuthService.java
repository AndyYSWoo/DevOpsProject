package cn.edu.nju.se.DevOpsProject.service;

import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.User;

public class UserAuthService {
	private UserDao userDao;

	public boolean authUser(String email, String psw){
		User user = userDao.getUserByEmail(email);
		if(user != null && user.getPsw().equals(psw)){
			return true;
		}
		return false;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
