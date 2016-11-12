package cn.edu.nju.se.DevOpsProject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.nju.se.DevOpsProject.model.Risk;

public class RiskDao {
	private SessionFactory sessionFactory;
	
	public int creatNewRisk(Risk risk){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id = (Integer)session.save(risk);
		tx.commit();
		return id;
	}
	
	public ArrayList<Risk> getRisksBysubmitterId(int submitterId){
		ArrayList<Risk> list = new ArrayList<Risk>();
		Session session = sessionFactory.openSession();
		String hql = "FROM Risk WHERE submitterId = "+submitterId;
		Query query = session.createQuery(hql);
		List<?> resultList = query.list();
		for(Object result : resultList){
			list.add((Risk)result);
		}
		return list;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
