package cn.edu.nju.se.DevOpsProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import cn.edu.nju.se.DevOpsProject.model.User;

public class UserDao {
	private SessionFactory sessionFactory;
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
}
