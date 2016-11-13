package cn.edu.nju.se.DevOpsProject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.nju.se.DevOpsProject.model.Description;
import cn.edu.nju.se.DevOpsProject.model.RiskEntry;
public class DescriptionDao {
	private SessionFactory sessionFactory;
	public int getDescriptionId(String content){
		Session session = sessionFactory.openSession();
		
		//ArrayList<Risk> list = new ArrayList<Risk>();
		//Session session = sessionFactory.openSession();
		String hql = "FROM Description WHERE content = "+"'"+content+"'";
		Query query = session.createQuery(hql);
		List<?> resultList = query.list();
		int id;
		if(resultList.size() == 0){
			Description des = new Description();
			des.setContent(content);
			id = createDescription(des);
		}else{
			id = ((Description)resultList.get(0)).getId();
		}
		session.close();
		return id;	
	}
	public int createDescription(Description description){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id = (Integer)session.save(description);
		tx.commit();
		return id;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
