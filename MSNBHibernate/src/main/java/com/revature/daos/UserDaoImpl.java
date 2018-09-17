package com.revature.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public List<User> getUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createQuery("from User").list();
	return users;
	}

	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
		User u = (User) s.get(User.class, id);
		s.close();
		return u;
	}

	public int createUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int userPK = (Integer) s.save(u);
		tx.commit();
		s.close();
		return userPK;
	}

	public void updateUser(User u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(u);
		tx.commit();
		s.close();
		
	}

	public void deleteUser(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User u = (User) s.get(User.class, id);
		if(u != null) {
			s.delete(u);
		}
		s.close();
		
	}

	public List<User> findUsersByLocId(int i) {
		Session s = HibernateUtil.getSession();
		String hql = "from User where loc_id = :Locat";
		Query q = s.createQuery(hql);
		q.setInteger("Locat", i);
		List<User> users = q.list();
		s.close();
		return users;
	}

	public long getUserCount() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(User.class);
		c.setProjection(Projections.rowCount());
		List<Long> rows = c.list();
		s.close();
		return rows.get(0);
	}

}
