package cn.edu.nju.se.DevOpsProject.action;

import cn.edu.nju.se.DevOpsProject.service.AdminAuthService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class LoginAction {
	private String email;
	private String password;
	public String getLogin() throws Exception{
		return "login";
	}
	public String postLogin() throws Exception{
		AdminAuthService adminAuthService = (AdminAuthService)ContextHelper.getBean("adminAuthService");
		if(adminAuthService.authAdmin(email, password)){
			return "admin";
		}else{
			
		}
		return "fail";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
