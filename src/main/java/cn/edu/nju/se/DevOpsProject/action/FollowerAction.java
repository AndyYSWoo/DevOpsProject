package cn.edu.nju.se.DevOpsProject.action;

import cn.edu.nju.se.DevOpsProject.dao.ResponsibleDao;
import cn.edu.nju.se.DevOpsProject.dao.RiskDao;
import cn.edu.nju.se.DevOpsProject.dao.RiskEntryDao;
import cn.edu.nju.se.DevOpsProject.dao.UserDao;
import cn.edu.nju.se.DevOpsProject.model.Description;
import cn.edu.nju.se.DevOpsProject.model.Responsible;
import cn.edu.nju.se.DevOpsProject.model.Risk;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
import cn.edu.nju.se.DevOpsProject.model.Threshold;
import cn.edu.nju.se.DevOpsProject.model.User;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class FollowerAction extends BaseAction {
	private List<Responsible> resList;
	private User user;
	private List<Risk> riskList;
	private Risk risk;
	private List<RiskEntry> riskEntryList;
	private RiskEntry lastEntry;
	private List<RiskEntry> entryList;
	private User submitter;
	private List<User> followerList;
	public String home() throws Exception{
		//RiskEntry entry =new RiskEntry();
		getUserFromSession();
		ResponsibleDao resDao = (ResponsibleDao)ContextHelper.getBean("responsibleDao");
		resList = resDao.getResponsibleByFollowerId(user.getId());
		riskList = new ArrayList<Risk>();
		for(Responsible res:resList){
			Risk temp = res.getRisk();
			if(temp.getEntries().get(0).getStatus() == 1){
				riskList.add(res.getRisk());
			}	
		}
		return "home";
	}
	public String riskDetail() throws Exception{
		getUserFromSession();
		//System.out.println("id"+id);
		int riskId = Integer.valueOf(request.getParameter("riskId"));
		RiskDao riskDao = (RiskDao)ContextHelper.getBean("riskDao");
		risk = riskDao.getRiskById(riskId);
		submitter = risk.getSubmitter();
		lastEntry = risk.getEntries().get(0);
		entryList = risk.getEntries();
		ResponsibleDao resDao = (ResponsibleDao)ContextHelper.getBean("responsibleDao");
		resList = resDao.getResponsiblesByRiskId(risk.getId());
		followerList = new ArrayList<User>();
		for(Responsible res:resList){
			followerList.add(res.getUser());
		}
		return "riskDetail";
	}
	public String addEntry() throws Exception{
		getUserFromSession();
		int possibility = Integer.valueOf(request.getParameter("possibility"));
		int influence = Integer.valueOf(request.getParameter("influence"));
		int riskId = Integer.valueOf(request.getParameter("riskId"));
		String description = request.getParameter("description");
		String threshold = request.getParameter("threshold");
		int status = Integer.valueOf(request.getParameter("status"));
		RiskEntry entry = new RiskEntry();
		Description desc = new Description();
		desc.setContent(description);
		Threshold thres = new Threshold();
		thres.setContent(threshold);
		entry.setChanger(user);
		entry.setChangerId(user.getId());
		entry.setCreatedTime(new Date());
		entry.setDescription(desc);
		entry.setThreshold(thres);
		entry.setInfluence(influence);
		entry.setPossibility(possibility);
		entry.setRiskId(riskId);
		entry.setStatus(status);
		entry.setThreshold(thres);
		
		RiskEntryDao resDao = (RiskEntryDao)ContextHelper.getBean("riskEntryDao");
		resDao.createAutoEntry(entry);
		return riskDetail();
	}
	public String closedRisk() throws Exception{
		getUserFromSession();
		ResponsibleDao resDao = (ResponsibleDao)ContextHelper.getBean("responsibleDao");
		resList = resDao.getResponsibleByFollowerId(user.getId());
		riskList = new ArrayList<Risk>();
		for(Responsible res:resList){
			Risk temp = res.getRisk();
			if(temp.getEntries().get(0).getStatus() == 2){
				riskList.add(res.getRisk());
			}	
		}
		return "closedRisk";
	}
	public String close() throws Exception{
		getUserFromSession();
		//System.out.println("id"+id);
		int riskId = Integer.valueOf(request.getParameter("riskId"));
		RiskDao riskDao = (RiskDao)ContextHelper.getBean("riskDao");
		risk = riskDao.getRiskById(riskId);
		lastEntry = risk.getEntries().get(0);
		RiskEntry closeEntry = new RiskEntry();
		closeEntry.setChangerId(user.getId());
		closeEntry.setCreatedTime(new Date());
		closeEntry.setDescriptionId(lastEntry.getDescriptionId());
		closeEntry.setThresholdId(lastEntry.getThresholdId());
		closeEntry.setInfluence(lastEntry.getInfluence());
		closeEntry.setPossibility(lastEntry.getPossibility());
		closeEntry.setRiskId(riskId);
		closeEntry.setStatus(2);
		RiskEntryDao resDao = (RiskEntryDao)ContextHelper.getBean("riskEntryDao");
		resDao.createEntry(closeEntry);

		return home();
	}
	public void getUserFromSession(){
		int userId = (Integer)session.get("userid");
		System.out.println("userId "+userId);
		UserDao userDao = (UserDao)ContextHelper.getBean("userDao");
		user = userDao.getUserById(userId);
	}
	public User getSubmitter() {
		return submitter;
	}
	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}
	public List<User> getFollowerList() {
		return followerList;
	}
	public void setFollowerList(List<User> followerList) {
		this.followerList = followerList;
	}
	public void setRiskList(List<Risk> riskList) {
		this.riskList = riskList;
	}
	public void setRiskEntryList(List<RiskEntry> riskEntryList) {
		this.riskEntryList = riskEntryList;
	}
	public Risk getRisk() {
		return risk;
	}
	public void setRisk(Risk risk) {
		this.risk = risk;
	}
	public List<RiskEntry> getRiskEntryList() {
		return riskEntryList;
	}
	public void setRiskEntryList(ArrayList<RiskEntry> riskEntryList) {
		this.riskEntryList = riskEntryList;
	}
	public RiskEntry getLastEntry() {
		return lastEntry;
	}
	public void setLastEntry(RiskEntry lastEntry) {
		this.lastEntry = lastEntry;
	}
	public List<RiskEntry> getEntryList() {
		return entryList;
	}
	public void setEntryList(List<RiskEntry> entryList) {
		this.entryList = entryList;
	}

	public List<Risk> getRiskList() {
		return riskList;
	}
	public void setRiskList(ArrayList<Risk> riskList) {
		this.riskList = riskList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
