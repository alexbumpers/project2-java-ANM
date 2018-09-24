package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Location;
import com.revature.models.MUser;
import com.revature.models.Preference;
import com.revature.models.PreferenceId;
import com.revature.services.LocationService;
import com.revature.services.MUserService;
import com.revature.services.PreferenceService;

@RestController
public class DAOController {

	@Autowired
	MUserService mUserService;
	
	@Autowired
	PreferenceService preferenceService;
	
	@Autowired
	LocationService locationService;
	
	@GetMapping(value="/locations", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Location> findAllLocations(){
		return locationService.findAllLocations();
	}
	@GetMapping(value="/preferences", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Preference> findAllPreferences(){
		return preferenceService.findAllPreferences();
	}
	
	@GetMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	public List<MUser> findAllUsers(){
		return mUserService.findAllMUsers();
	}
	
	@GetMapping(value="/users/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public MUser getMUserById(@PathVariable("id") int id) {
		return mUserService.findMUserById(id);
	}
	
	@GetMapping(value="/users/{email}", produces=MediaType.APPLICATION_JSON_VALUE)
	public MUser getMUserByUsername(@PathVariable("email") String email) {
		return mUserService.findMUserByUsername(email);
	}
	
	@GetMapping(value="/locations/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Location getLocationById(@PathVariable("id") int id) {
		return locationService.findLocationById(id);
	}
	
	@GetMapping(value="/preferences/{id}/{pLevel}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Preference getPreferenceById(@PathVariable("id") int id, @PathVariable("pLevel") int pLevel) {
		PreferenceId pId = new PreferenceId(id,pLevel);
		return preferenceService.findPreferenceByKey(pId);
	}
	
	@PostMapping(value="/users",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public MUser addMUser(@RequestBody MUser m) {
		return mUserService.addMUser(m);
	}
	
	@PostMapping(value="/locations",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Location addLocation(@RequestBody Location l) {
		return locationService.addLocation(l);
	}
	
	@PostMapping(value="/preferences",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Preference addPreference(@RequestBody Preference p) {
		return preferenceService.addPreference(p);
	}
	
	@PutMapping(value="/users",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public MUser updateUser(@RequestBody MUser m) {
		return mUserService.updateMUser(m);
	}
	
	@PutMapping(value="/locations",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Location updateLocation(@RequestBody Location l) {
		return locationService.updateLocation(l);
	}
	
	@PutMapping(value="/preferences",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Preference updatePreference(@RequestBody Preference p) {
		return preferenceService.updatePreference(p);
	}
	
	@DeleteMapping(value="/users",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public MUser deleteUser(@RequestBody MUser m) {
		return mUserService.deleteMUser(m);
	}
	
	@DeleteMapping(value="/locations",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Location deleteLocation(@RequestBody Location l) {
		return locationService.deleteLocation(l);
	}
	
	@DeleteMapping(value="/preferences",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Preference deletePreference(@RequestBody Preference p) {
		return preferenceService.deletePreference(p);
	}
	
	@GetMapping(value="/login")
	public MUser loggedInMUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		return mUserService.login(email, password);
	}
	
	@GetMapping(value="/users/genre/{genre}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<MUser> getMUsersByGenre(@PathVariable("genre") String genre) {
		return mUserService.findMUserByGenre(genre);
	}
}
