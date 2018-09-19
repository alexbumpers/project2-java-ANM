package com.revature.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.revature.models.MUser;
import com.revature.models.Preference;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public List<MUser> getUsers() {
		Session s = HibernateUtil.getSession();
		List<MUser> users = s.createQuery("from User").list();
	return users;
	}

	public MUser getUserById(int id) {
		Session s = HibernateUtil.getSession();
		MUser u = (MUser) s.get(MUser.class, id);
		s.close();
		return u;
	}

	public int createUser(MUser u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int userPK = (Integer) s.save(u);
		tx.commit();
		s.close();
		return userPK;
	}

	public void updateUser(MUser u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(u);
		tx.commit();
		s.close();
		
	}

	public void deleteUser(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		MUser u = (MUser) s.get(MUser.class, id);
		if(u != null) {
			s.delete(u);
		}
		s.close();
		
	}

	public List<MUser> findUsersByLocId(int i) {
		Session s = HibernateUtil.getSession();
		String hql = "from User where loc_id = :Locat";
		Query q = s.createQuery(hql);
		q.setInteger("Locat", i);
		List<MUser> users = q.list();
		s.close();
		return users;
	}

	public long getUserCount() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(MUser.class);
		c.setProjection(Projections.rowCount());
		List<Long> rows = c.list();
		s.close();
		return rows.get(0);
	}

	public static double getMatchTotal(MUser one, MUser two) {
		/*
		 * The method should, when the two users have a genre match,
		 * take the prefLevel of that genre, and add it to the total.
		 * Then, once all of the genres have been gone through, it
		 * divides the total by 1.1. The max should be 100. This 
		 * number represents a percentage of match.
		 */
		List<Preference> user1 = one.getPrefs();
		List<Preference> user2 = two.getPrefs();
		double total=0.0;
		for(Preference p1:user1) {
			for(Preference p2:user2) {
				if(p1.getGenre().equals(p2.getGenre())){
					total += p1.getPrefLevel()+p2.getPrefLevel();
				}
			}
		}
		return total/1.1;
	}

	@Override
	public MUser getUserByEmailPass(String email, String pass) {
		Session s = HibernateUtil.getSession();
		String hql = "from MUser where email = :eVar AND password = :pVar";
		Query q = s.createQuery(hql);
		q.setString("eVar", email);
		q.setString("pVar", pass);
		List<MUser> m = q.list();
		return m.get(0);
	}
}
