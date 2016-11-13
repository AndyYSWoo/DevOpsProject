package cn.edu.nju.se.DevOpsProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
public class RiskEntryDao {
	private SessionFactory sessionFactory;
	public void createNewEntry(RiskEntry entry){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entry);
		tx.commit();
		session.close();	
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
		//dao.createEntry(entry);
		
	}
}
