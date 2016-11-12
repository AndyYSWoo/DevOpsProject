package cn.edu.nju.se.DevOpsProject.service;

import cn.edu.nju.se.DevOpsProject.dao.AdminDao;
import cn.edu.nju.se.DevOpsProject.model.Admin;

public class AdminAuthService {
	private AdminDao adminDao;
	public boolean authAdmin(String email, String psw){
		Admin admin = adminDao.getAdminByEmail(email);
		if(admin != null && admin.getPsw().equals(psw)){
			return true;
		}
		return false;
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
}
