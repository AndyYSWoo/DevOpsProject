package cn.edu.nju.se.DevOpsProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
import cn.edu.nju.se.DevOpsProject.util.ContextHelper;
public class RiskEntryDao {
	
	private SessionFactory sessionFactory;
	
	public void createEntry(RiskEntry entry){
		Session session = sessionFactory.openSession();
		System.out.println(entry.getDescriptionId()+"!!!!!!!!!!!!!!!!!!!!!");
		Transaction tx = session.beginTransaction();
		entry.setThreshold(null);
		entry.setDescription(null);
		session.save(entry);
		tx.commit();
		session.close();
	}
	public void createAutoEntry(RiskEntry entry){
		DescriptionDao descDao = (DescriptionDao)ContextHelper.getBean("descriptionDao");
		ThresholdDao thresDao = (ThresholdDao)ContextHelper.getBean("thresholdDao");
				
		
		int thresId = thresDao.getThresholdId(entry.getThreshold().getContent());
		int descId = descDao.getDescriptionId(entry.getDescription().getContent());
		entry.setThresholdId(thresId);
		entry.setDescriptionId(descId);
		
		createEntry(entry);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args){
		RiskEntry entry = new RiskEntry();
		entry.setChangerId(1);
		entry.setId(1);
		entry.setRiskId(3);
		RiskEntryDao dao = new RiskEntryDao();
		dao.createEntry(entry);
		
	}
}
