package cn.edu.nju.se.DevOpsProject.action;

import cn.edu.nju.se.DevOpsProject.model.RiskEntry;

public class FollowerAction extends BaseAction {
	public String home() throws Exception{
		RiskEntry entry =new RiskEntry();
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
}
