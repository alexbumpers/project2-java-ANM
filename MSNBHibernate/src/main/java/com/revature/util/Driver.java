package com.revature.util;

import org.hibernate.Session;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.MUser;

public class Driver {
	public static void main(String[] args) {
	Session con = HibernateUtil.getSession();
	con.close();
	UserDao ud = new UserDaoImpl();
	MUser user1 = ud.getUserById(1);
	MUser user2 = ud.getUserById(2);
	
	System.out.println(user1.toString());
	System.out.println(user2.toString());
	
	System.out.println(UserDaoImpl.getMatchTotal(user1, user2));
	}
}
