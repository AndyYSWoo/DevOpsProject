package cn.edu.nju.se.DevOpsProject.service;

import java.util.ArrayList;

import cn.edu.nju.se.DevOpsProject.dao.ResponsibleDao;
import cn.edu.nju.se.DevOpsProject.dao.RiskDao;
import cn.edu.nju.se.DevOpsProject.dao.RiskEntryDao;
import cn.edu.nju.se.DevOpsProject.model.Responsible;
import cn.edu.nju.se.DevOpsProject.model.Risk;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;

public class ManagerService {
	private RiskDao riskDao;
	private ResponsibleDao responsibleDao;
	private RiskEntryDao riskEntryDao;
	
	public boolean createNewRisk(Risk risk,RiskEntry riskEntry){
		riskDao.creatNewRisk(risk);
		riskEntryDao.createEntry(riskEntry);
		return true;
	}
	
	public boolean addResponsible(int riskEntryId,ArrayList<Integer> userIds){
		for(int userid:userIds){
			Responsible responsible = new Responsible();
			responsible.setRiskEntryId(riskEntryId);
			responsible.setUserId(userid);
			responsibleDao.creatNewResponsible(responsible);
		}
		return true;
	}
	
	public void getAllRisk(ArrayList<Risk> riskOfNewCreated,
			ArrayList<Risk> riskOfProcessing, ArrayList<Risk> riskOfclosed,int submitterId) {
		ArrayList<Risk> list = riskDao.getRisksBysubmitterId(submitterId);
		//TODO 
	}
	
	public RiskDao getRiskDao() {
		return riskDao;
	}
	public void setRiskDao(RiskDao riskDao) {
		this.riskDao = riskDao;
	}
	public ResponsibleDao getResponsibleDao() {
		return responsibleDao;
	}
	public void setResponsibleDao(ResponsibleDao responsibleDao) {
		this.responsibleDao = responsibleDao;
	}
	
	
}
