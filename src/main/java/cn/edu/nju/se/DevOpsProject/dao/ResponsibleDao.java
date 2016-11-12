package cn.edu.nju.se.DevOpsProject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.nju.se.DevOpsProject.model.Responsible;

public class ResponsibleDao {
private SessionFactory sessionFactory;
	
	public int creatNewResponsible(Responsible responsible){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id = (Integer)session.save(responsible);
		tx.commit();
		return id;
	}
	
	public ArrayList<Responsible> getResponsiblesByRisk_entryId(int riskEntryId){
		ArrayList<Responsible> list = new ArrayList<Responsible>();
		Session session = sessionFactory.openSession();
		String hql = "FROM Risk WHERE riskEntryId = "+riskEntryId;
		Query query = session.createQuery(hql);
		List<?> resultList = query.list();
		for(Object result : resultList){
			list.add((Responsible)result);
		}
		return list;
	}
	
	public ArrayList<Responsible> getResponsibleByFollowerId(int followerId){
		ArrayList<Responsible> list = new ArrayList<Responsible>();
		Session session = sessionFactory.openSession();
		String hql = "FROM Risk WHERE user_id = "+ followerId;
		Query query = session.createQuery(hql);
		List<?> resultList = query.list();
		for(Object result : resultList){
			list.add((Responsible)result);
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
