package cn.edu.nju.se.DevOpsProject.action;

import java.util.List;

import cn.edu.nju.se.DevOpsProject.model.User;
import cn.edu.nju.se.DevOpsProject.service.UserModService;
import cn.edu.nju.se.DevOpsProject.service.UserQueryService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class AdminAction extends BaseAction{
	private List<User> users;
	private int userIdToDisable;
	public String home() throws Exception{
		UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
		users = userQueryService.getActiveUsers();
		return "homePage";
	}
	
	public String disableUser() throws Exception{
		UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
		User user = userQueryService.getUserById(userIdToDisable);
		user.setStatus(0);
		
		UserModService userModService = (UserModService)ContextHelper.getBean("userModService");
		userModService.updateUser(user);
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
}
