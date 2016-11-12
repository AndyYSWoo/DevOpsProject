package cn.edu.nju.se.DevOpsProject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import cn.edu.nju.se.DevOpsProject.model.User;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		Session session = sessionFactory.openSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<?> results = query.list();
		for(Object result : results){
			users.add((User)result);
		}
		return users;
	}
	
	public User getUserById(String id){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		List list = criteria.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}else {
			return ((User)list.get(0));
		}
	}
	
	public User getUserByEmail(String email){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		List list = criteria.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}else {
			return ((User)list.get(0));
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}