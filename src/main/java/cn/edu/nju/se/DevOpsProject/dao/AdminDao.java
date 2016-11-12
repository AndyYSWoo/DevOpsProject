package cn.edu.nju.se.DevOpsProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import cn.edu.nju.se.DevOpsProject.model.Admin;

public class AdminDao {
	private SessionFactory sessionFactory;
	public Admin getAdminByEmail(String email){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("email", email));
		List list = criteria.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}else {
			return ((Admin)list.get(0));
		}
	}
}
