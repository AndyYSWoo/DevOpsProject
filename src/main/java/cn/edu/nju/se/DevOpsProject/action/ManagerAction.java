package cn.edu.nju.se.DevOpsProject.action;

import java.util.ArrayList;

import cn.edu.nju.se.DevOpsProject.model.Risk;
import cn.edu.nju.se.DevOpsProject.service.ManagerService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class ManagerAction extends BaseAction{
	ArrayList<Risk> riskOfNewCreated;
	ArrayList<Risk> riskOfProcessing;
	ArrayList<Risk> riskOfclosed;
	
	public String manage() throws Exception{
		ManagerService managerService = (ManagerService)ContextHelper.getBean("managerService");
		riskOfNewCreated = new ArrayList<Risk>();
		riskOfProcessing = new ArrayList<Risk>();
		riskOfclosed = new ArrayList<Risk>();
		int userId = (int)session.get("userid");
		managerService.getAllRisk(riskOfNewCreated,riskOfProcessing,riskOfclosed,userId);	
		return "manage";
	}
	
	
	public String createRisk() throws Exception{
		return "success";
	}
	
	public String createResponsible() throws Exception{
		
		return "success";
	}
	
}
