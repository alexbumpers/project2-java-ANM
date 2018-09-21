package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Location;
import com.revature.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	
	@Autowired
	LocationRepository locaRepo;
	@Override
	public List<Location> findAllLocations() {
		return locaRepo.findAll();
	}

	@Override
	public Location findLocationById(int id) {
		return locaRepo.getOne(id);
	}

	@Override
	public Location addLocation(Location newLocation) {
		return locaRepo.save(newLocation);
	}

	@Override
	public Location updateLocation(Location location) {
		return locaRepo.save(location);
	}

	@Override
	public Location deleteLocation(Location location) {
		locaRepo.delete(location);
		return location;
	}

}
