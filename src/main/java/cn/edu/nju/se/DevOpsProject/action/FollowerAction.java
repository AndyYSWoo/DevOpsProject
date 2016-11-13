package cn.edu.nju.se.DevOpsProject.action;

import cn.edu.nju.se.DevOpsProject.dao.ResponsibleDao;
import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.Responsible;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
import cn.edu.nju.se.DevOpsProject.model.User;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

import java.util.ArrayList;
public class FollowerAction extends BaseAction {
	private ArrayList<Responsible> resList;
	private User user;
	public String home() throws Exception{
		RiskEntry entry =new RiskEntry();
		int userId = (Integer)session.get("userid");
		System.out.println("userId "+userId);
		UserDao userDao = (UserDao)ContextHelper.getBean("userDao");
		user = userDao.getUserById(userId);
		
		
		//ResponsibleDao resDao = new ResponsibleDao();
		//ArrayList<Responsible> resList = resDao.getResponsibleByFollowerId(userId);
//		ShopDao shopDao = (ShopDao) ContextHelper.getBean("shopDao");
//		shops = shopDao.getAllShops();
//		WaiterDao waiterDao = (WaiterDao) ContextHelper.getBean("waiterDao");
//		waiters = waiterDao.getAllWaiters();
//		shopNum = shops.size();
//		waiterNum = waiters.size();
//		MemberDao memberDao = (MemberDao) ContextHelper.getBean("memberDao");
//		memberNum = memberDao.getMemberAmount();
		return "home";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String riskDetail() throws Exception{
		return "riskDetail";
	}
	public String addEntry() throws Exception{
		
		return "addEntry";
	}
}
