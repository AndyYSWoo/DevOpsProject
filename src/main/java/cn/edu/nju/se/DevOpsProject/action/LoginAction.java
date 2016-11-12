package cn.edu.nju.se.DevOpsProject.action;

import cn.edu.nju.se.DevOpsProject.service.AdminAuthService;
import cn.edu.nju.se.DevOpsProject.service.UserAuthService;
import cn.edu.nju.se.DevOpsProject.service.UserQueryService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class LoginAction extends BaseAction{
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
			UserAuthService userAuthService = (UserAuthService)ContextHelper.getBean("userAuthService");
			if(userAuthService.authUser(email, password)){
				return "user";
			}
			UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
			
			session.put("userid", userQueryService.getUserByEmail(email).getId());
		}
		return "fail";
	}
	public String logOut(){
		session.clear();
		return "out";
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
