package com.revature.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.revature.models.Location;
import com.revature.util.HibernateUtil;

public class LocationDaoImpl implements LocationDao {

	public List<Location> getLocations() {
		Session s = HibernateUtil.getSession();
		List<Location> locations = s.createQuery("from Location").list();
	return locations;
	}

	public Location getLocationById(int id) {
		Session s = HibernateUtil.getSession();
		Location l = (Location) s.get(Location.class, id);
		s.close();
		return l;
	}

	public int createLocation(Location l) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int locationPK = (Integer) s.save(l);
		tx.commit();
		s.close();
		return locationPK;
	}

	public void updateLocation(Location l) {
		Session s = HibernateUtil.getSession();
		Transaction tx= s.beginTransaction();
		s.update(l);
		tx.commit();
		s.close();
		
	}

	public void deleteLocation(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Location l = (Location) s.get(Location.class, id);
		if(l!=null) {
			s.delete(l);
		}
		s.close();
		
	}

	public long getLocationCount() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Location.class);
		c.setProjection(Projections.rowCount());
		List<Long> rows = c.list();
		s.close();
		return rows.get(0);
	}

}
