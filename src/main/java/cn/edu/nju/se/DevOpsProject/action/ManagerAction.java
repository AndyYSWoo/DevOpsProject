package cn.edu.nju.se.DevOpsProject.action;

import java.util.ArrayList;
import java.util.List;


import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.Risk;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
import cn.edu.nju.se.DevOpsProject.model.User;
import cn.edu.nju.se.DevOpsProject.service.ManagerService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class ManagerAction extends BaseAction{
	private ArrayList<Risk> riskOfNewCreated;
	private ArrayList<Risk> riskOfProcessing;
	private ArrayList<Risk> riskOfclosed;
	private ArrayList<Integer> userIds;
	
	public String manage() throws Exception{
		ManagerService managerService = (ManagerService)ContextHelper.getBean("managerService");
		riskOfNewCreated = new ArrayList<Risk>();
		riskOfProcessing = new ArrayList<Risk>();
		riskOfclosed = new ArrayList<Risk>();
		int userId = 0;
		try{
			userId = (int)session.get("userid");
		}catch(Exception e){
			return "login";
		}
		managerService.getAllRisk(riskOfNewCreated,riskOfProcessing,riskOfclosed,userId);	
		UserDao userdao = (UserDao)ContextHelper.getBean("userDao");
		List<User> users = userdao.getAllUsers();
		for(User user:users){
			if(user.getRole()==1){
				userIds.add(user.getId());
			}
		}
		return "manage";
	}
	
	
	public String createRisk() throws Exception{
		Risk risk = new Risk();
		RiskEntry riskEntry = new RiskEntry();
		ManagerService managerService = (ManagerService)ContextHelper.getBean("managerService");
		managerService.createNewRisk(risk, riskEntry);
		return "success";
	}
	
	public String createResponsible() throws Exception{
		ManagerService managerService = (ManagerService)ContextHelper.getBean("managerService");
		int riskEntryId = (int)session.get("riskEntryId");
		ArrayList<User> users = (ArrayList<User>)session.get("users");
		managerService.addResponsible(riskEntryId, userIds);
		return "success";
	}


	public ArrayList<Risk> getRiskOfNewCreated() {
		return riskOfNewCreated;
	}


	public void setRiskOfNewCreated(ArrayList<Risk> riskOfNewCreated) {
		this.riskOfNewCreated = riskOfNewCreated;
	}


	public ArrayList<Risk> getRiskOfProcessing() {
		return riskOfProcessing;
	}


	public void setRiskOfProcessing(ArrayList<Risk> riskOfProcessing) {
		this.riskOfProcessing = riskOfProcessing;
	}


	public ArrayList<Risk> getRiskOfclosed() {
		return riskOfclosed;
	}


	public void setRiskOfclosed(ArrayList<Risk> riskOfclosed) {
		this.riskOfclosed = riskOfclosed;
	}
	
	
}
