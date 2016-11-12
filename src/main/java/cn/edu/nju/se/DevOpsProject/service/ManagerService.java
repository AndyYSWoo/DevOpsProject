package cn.edu.nju.se.DevOpsProject.service;

import cn.edu.nju.se.DevOpsProject.dao.ResponsibleDao;
import cn.edu.nju.se.DevOpsProject.dao.RiskDao;

public class ManagerService {
	private RiskDao riskDao;
	private ResponsibleDao responsibleDao;
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
