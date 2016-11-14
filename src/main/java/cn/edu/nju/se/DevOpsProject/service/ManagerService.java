package cn.edu.nju.se.DevOpsProject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.nju.se.DevOpsProject.dao.ResponsibleDao;
import cn.edu.nju.se.DevOpsProject.dao.RiskDao;
import cn.edu.nju.se.DevOpsProject.dao.RiskEntryDao;
import cn.edu.nju.se.DevOpsProject.dao.ThresholdDao;
import cn.edu.nju.se.DevOpsProject.model.Responsible;
import cn.edu.nju.se.DevOpsProject.model.Risk;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
import cn.edu.nju.se.DevOpsProject.model.Threshold;

public class ManagerService {
	private RiskDao riskDao;
	private ResponsibleDao responsibleDao;
	private RiskEntryDao riskEntryDao;
	private ThresholdDao thresholdDao;
	
	public boolean createNewRisk(Risk risk,Threshold threshold,RiskEntry riskEntry){
		int riskId = riskDao.creatNewRisk(risk);
		int thresholdId = thresholdDao.creatNewThreshold(threshold);
		riskEntry.setRiskId(riskId);
		riskEntry.setThresholdId(thresholdId);
		riskEntryDao.createEntry(riskEntry);
		return true;
	}
	
	public boolean addResponsible(int riskId,List<Integer> userIds){
		Risk risk = riskDao.getRiskById(riskId);
		RiskEntry riskEntry = new RiskEntry();
		RiskEntry temp = risk.getEntries().get(0);
		riskEntry.setCreatedTime(new Date());
		riskEntry.setDescriptionId(temp.getDescriptionId());
		riskEntry.setInfluence(temp.getInfluence());
		riskEntry.setPossibility(temp.getPossibility());
		riskEntry.setRiskId(riskId);
		riskEntry.setStatus(1);
		riskEntry.setThresholdId(temp.getThresholdId());
		riskEntryDao.createEntry(riskEntry);
		for(int userid:userIds){
			Responsible responsible = new Responsible();
			responsible.setRiskId(riskId);
			responsible.setUserId(userid);
			responsibleDao.creatNewResponsible(responsible);
		}
		return true;
	}
	
	public void getAllRisk(ArrayList<Risk> riskOfNewCreated,
			ArrayList<Risk> riskOfProcessing, ArrayList<Risk> riskOfclosed,int submitterId) {
		ArrayList<Risk> list = riskDao.getRisksBysubmitterId(submitterId);
		for(Risk risk:list){
			if(risk.getEntries().get(0).getStatus()==0){
				riskOfNewCreated.add(risk);
			}else if(risk.getEntries().get(0).getStatus()==1){
				riskOfProcessing.add(risk);
			}else{
				riskOfclosed.add(risk);
			}
		}
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

	public RiskEntryDao getRiskEntryDao() {
		return riskEntryDao;
	}

	public void setRiskEntryDao(RiskEntryDao riskEntryDao) {
		this.riskEntryDao = riskEntryDao;
	}

	public ThresholdDao getThresholdDao() {
		return thresholdDao;
	}

	public void setThresholdDao(ThresholdDao thresholdDao) {
		this.thresholdDao = thresholdDao;
	}
	
	
}
