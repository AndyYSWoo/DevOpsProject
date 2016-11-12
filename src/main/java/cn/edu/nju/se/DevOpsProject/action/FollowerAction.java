package cn.edu.nju.se.DevOpsProject.action;

import cn.edu.nju.se.DevOpsProject.dao.ResponsibleDao;
import cn.edu.nju.se.DevOpsProject.model.Responsible;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;

import java.util.ArrayList;
public class FollowerAction extends BaseAction {
	private ArrayList<Responsible> resList;
	public String home() throws Exception{
		RiskEntry entry =new RiskEntry();
		int userId = (Integer)session.get("userid");
		ResponsibleDao resDao = new ResponsibleDao();
		ArrayList<Responsible> resList = resDao.getResponsibleByFollowerId(userId);
//		ShopDao shopDao = (ShopDao) ContextHelper.getBean("shopDao");
//		shops = shopDao.getAllShops();
//		WaiterDao waiterDao = (WaiterDao) ContextHelper.getBean("waiterDao");
//		waiters = waiterDao.getAllWaiters();
//		shopNum = shops.size();
//		waiterNum = waiters.size();
//		MemberDao memberDao = (MemberDao) ContextHelper.getBean("memberDao");
//		memberNum = memberDao.getMemberAmount();
		return "homePage";
	}
	public String addEntry() throws Exception{
		
	}
}
