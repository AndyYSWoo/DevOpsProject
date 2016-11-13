package cn.edu.nju.se.DevOpsProject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.nju.se.DevOpsProject.model.Risk;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
public class ThresholdDao {
	private SessionFactory sessionFactory;
	public int getThresholdId(String threshold){
		Session session = sessionFactory.openSession();
		
		//ArrayList<Risk> list = new ArrayList<Risk>();
		//Session session = sessionFactory.openSession();
		String sql = "FROM Threshold WHERE content = "+"'"+threshold+"'";
		Query query = session.createQuery(sql);
		List<?> resultList = query.list();
		if(resultList.size() == 0){
			
		}
		session.close();
		return 1;
			
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
