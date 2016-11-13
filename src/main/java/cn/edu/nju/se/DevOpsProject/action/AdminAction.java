package cn.edu.nju.se.DevOpsProject.action;

import java.util.List;

import cn.edu.nju.se.DevOpsProject.model.User;
import cn.edu.nju.se.DevOpsProject.service.UserModService;
import cn.edu.nju.se.DevOpsProject.service.UserQueryService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class AdminAction extends BaseAction{
	private List<User> users;
	
	private int userIdToDisable;
	private int userIdToEnable;
	
	private String nameToAdd;
	private String emailToAdd;
	private String passwordToAdd;
	private int roleToAdd;
	public String home() throws Exception{
		UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
		users = userQueryService.getActiveUsers();
		return "homePage";
	}
	public String inactives() throws Exception{
		UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
		users = userQueryService.getInactiveUsers();
		return "inactives";
	}
	
	public String disableUser() throws Exception{
		UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
		User user = userQueryService.getUserById(userIdToDisable);
		user.setStatus(0);
		
		UserModService userModService = (UserModService)ContextHelper.getBean("userModService");
		userModService.updateUser(user);
		
		return "success";
	}
	
	public String enableUser() throws Exception{
		UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
		User user = userQueryService.getUserById(userIdToEnable);
		user.setStatus(1);
		
		UserModService userModService = (UserModService)ContextHelper.getBean("userModService");
		userModService.updateUser(user);

		return "success";
	}
	
	public String addUser() throws Exception{
		User user = new User();
		user.setName(nameToAdd);
		user.setEmail(emailToAdd);
		user.setPsw(passwordToAdd);
		user.setRole(roleToAdd);
		user.setStatus(1);
		
		UserModService userModService = (UserModService)ContextHelper.getBean("userModService");
		userModService.addUser(user);
		
		return "success";
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getUserIdToDisable() {
		return userIdToDisable;
	}

	public void setUserIdToDisable(int userIdToDisable) {
		this.userIdToDisable = userIdToDisable;
	}

	public String getNameToAdd() {
		return nameToAdd;
	}

	public void setNameToAdd(String nameToAdd) {
		this.nameToAdd = nameToAdd;
	}

	public String getEmailToAdd() {
		return emailToAdd;
	}

	public void setEmailToAdd(String emailToAdd) {
		this.emailToAdd = emailToAdd;
	}

	public String getPasswordToAdd() {
		return passwordToAdd;
	}

	public void setPasswordToAdd(String passwordToAdd) {
		this.passwordToAdd = passwordToAdd;
	}

	public int getRoleToAdd() {
		return roleToAdd;
	}

	public void setRoleToAdd(int roleToAdd) {
		this.roleToAdd = roleToAdd;
	}
	public int getUserIdToEnable() {
		return userIdToEnable;
	}
	public void setUserIdToEnable(int userIdToEnable) {
		this.userIdToEnable = userIdToEnable;
	}
}
