package cn.edu.nju.se.DevOpsProject.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;









import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.Risk;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
import cn.edu.nju.se.DevOpsProject.model.Threshold;
import cn.edu.nju.se.DevOpsProject.model.User;
import cn.edu.nju.se.DevOpsProject.service.ManagerService;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

public class ManagerAction extends BaseAction{
	private ArrayList<Risk> riskOfNewCreated;
	private ArrayList<Risk> riskOfProcessing;
	private ArrayList<Risk> riskOfclosed;
	private ArrayList<User> userlist;
	private String content;
	private String title;
	private String threshold;
	private int influence;
	private int possibility;
	private Risk currentRisk;
	private User user;
	private List<Integer> userIds;
	
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
		user = userdao.getUserById(userId);
		return "manage";
	}
	
	
	public String createRisk() throws Exception{
		Risk risk = new Risk();
		risk.setContent(content);
		risk.setTitle(title);
		risk.setSubmitterId((int)session.get("userid"));
		Threshold thre = new Threshold();
		thre.setContent(threshold);
		RiskEntry riskEntry = new RiskEntry();
		riskEntry.setCreatedTime(new Date());
		riskEntry.setInfluence(influence);
		riskEntry.setPossibility(possibility);
		ManagerService managerService = (ManagerService)ContextHelper.getBean("managerService");
		managerService.createNewRisk(risk,thre,riskEntry);
		return "success";
	}
	
	public String riskDetail() throws Exception{
		manage();
		int riskId = Integer.parseInt(request.getParameter("riskId"));
		for(Risk r:riskOfNewCreated){
			if(r.getId()==riskId){
				currentRisk = r;
				UserDao userdao = (UserDao)ContextHelper.getBean("userDao");
				List<User> users = userdao.getAllUsers();
				userlist = new ArrayList<User>();
				for(User user:users){
					if(user.getRole()==1){
						userlist.add(user);
					}
				}
				return "manager_assign";
			}
		}
		for(Risk r:riskOfProcessing){
			if(r.getId()==riskId){
				currentRisk = r;
				return "manager_see_processing";
			}
		}
		for(Risk r:riskOfclosed){
			if(r.getId()==riskId){
				currentRisk = r;
				return "manager_see_closed";
			}
		}
		return "risk_detail";
	}
	
	public String createResponsible() throws Exception{
		ManagerService managerService = (ManagerService)ContextHelper.getBean("managerService");
		int riskId = Integer.parseInt(request.getParameter("riskId"));
		System.out.println(riskId+"----------------"+userIds.size());
		managerService.addResponsible(riskId, userIds);
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



	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getThreshold() {
		return threshold;
	}


	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}


	public int getInfluence() {
		return influence;
	}


	public void setInfluence(int influence) {
		this.influence = influence;
	}


	public int getPossibility() {
		return possibility;
	}


	public void setPossibility(int possibility) {
		this.possibility = possibility;
	}


	public Risk getCurrentRisk() {
		return currentRisk;
	}


	public void setCurrentRisk(Risk currentRisk) {
		this.currentRisk = currentRisk;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public ArrayList<User> getUserlist() {
		return userlist;
	}


	public void setUserlist(ArrayList<User> userlist) {
		this.userlist = userlist;
	}


	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}


	public List<Integer> getUserIds() {
		return userIds;
	}
	
	
}
