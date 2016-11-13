package cn.edu.nju.se.DevOpsProject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	public List<User> getActiveUsers(){
		List<User> users = new ArrayList<>();
		Session session = sessionFactory.openSession();
		String hql = "FROM User WHERE status=1";
		Query query = session.createQuery(hql);
		List<?> results = query.list();
		for(Object result : results){
			users.add((User)result);
		}
		return users;
	}
	
	public List<User> getInactiveUsers(){
		List<User> users = new ArrayList<>();
		Session session = sessionFactory.openSession();
		String hql = "FROM User WHERE status=0";
		Query query = session.createQuery(hql);
		List<?> results = query.list();
		for(Object result : results){
			users.add((User)result);
		}
		return users;
	}
	
	public User getUserById(int id){
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
	
	public void updateUser(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}
	
	public void addUser(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
