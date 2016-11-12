package cn.edu.nju.se.DevOpsProject.action;

import java.util.List;

import cn.edu.nju.se.DevOpsProject.model.User;
import cn.edu.nju.se.DevOpsProject.service.UserQueryService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class AdminAction extends BaseAction{
	private List<User> users;
	public String home() throws Exception{
		UserQueryService userQueryService = (UserQueryService)ContextHelper.getBean("userQueryService");
		users = userQueryService.getActiveUsers();
		return "homePage";
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
