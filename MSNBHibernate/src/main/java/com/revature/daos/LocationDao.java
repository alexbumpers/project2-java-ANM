package com.revature.daos;

import java.util.List;

import com.revature.models.Location;

public interface LocationDao {
	public List<Location> getLocations();
	public Location getLocationById(int id);
	public int createLocation(Location l);
	public void updateLocation(Location l);
	public void deleteLocation(int id);
	public long getLocationCount();
}
