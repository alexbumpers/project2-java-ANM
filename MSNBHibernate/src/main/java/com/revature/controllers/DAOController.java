package com.revature.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Friend;
import com.revature.models.Location;
import com.revature.models.MUser;
import com.revature.models.Preference;
import com.revature.models.PreferenceId;
import com.revature.services.FriendService;
import com.revature.services.LocationService;
import com.revature.services.MUserService;
import com.revature.services.PreferenceService;

@Controller
@Component
public class DAOController {

	@Autowired
	MUserService mUserService;
	
	@Autowired
	PreferenceService preferenceService;
	
	@Autowired
	FriendService friendService;
	
	@Autowired
	LocationService locationService;
	
	@GetMapping(value="/locations", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Location> findAllLocations(){
		return locationService.findAllLocations();
	}
	@GetMapping(value="/preferences", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Preference> findAllPreferences(){
		return preferenceService.findAllPreferences();
	}
	
	@GetMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MUser> findAllUsers(){
		return mUserService.findAllMUsers();
	}
	
	@GetMapping(value="/friends", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Friend> findAllFriends(){
		return friendService.findAllFriends();
	}
	
	@GetMapping(value="/friends/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Friend findFriendById(@PathVariable("id") int id){
		return friendService.findFriendById(id);
	}
	
	@GetMapping(value="/friends/p/{person}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Friend> findFriendByPerson(@PathVariable("person") int person){
		return friendService.findFriendsByPerson(person);
	}
	
	@GetMapping(value="/friends/i/{isFriendsWith}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Friend> findFriendByIsFriendsWith(@PathVariable("isFriendsWith") int isFriendsWith){
		return friendService.findFriendsByIsFriendsWith(isFriendsWith);
	}
	
	@PutMapping(value="/friends",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Friend updateFriend(Friend friend) {
		friendService.addFriend(friend);
		return friend;
	}
	
	@PostMapping(value="/friends",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Friend addFriend(@RequestBody Friend friend) {
		friendService.addFriend(friend);
		return friend;
	}
	
	@DeleteMapping(value="/friends/{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteFriend(Friend friend) {
		friendService.deleteFriend(friend);
	}
	
	@GetMapping(value="/users/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MUser getMUserById(@PathVariable("id") int id) {
		return mUserService.findMUserById(id);
	}
	
	@GetMapping(value="/users/byemail/{email}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MUser getMUserByUsername(@PathVariable("email") String email) {
		return mUserService.findMUserByUsername(email);
	}
	
	@GetMapping(value="/locations/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Location getLocationById(@PathVariable("id") int id) {
		return locationService.findLocationById(id);
	}
	
	@GetMapping(value="/preferences/pref/{id}/{pLevel}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Preference getPreferenceById(@PathVariable("id") int id, @PathVariable("pLevel") int pLevel) {
		PreferenceId pId = new PreferenceId(id,pLevel);
		return preferenceService.findPreferenceByKey(pId);
	}
	
	@GetMapping(value="/preferences/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Preference> getPreferencesByUserId(@PathVariable("id") int id){
		List<Preference> preferences= preferenceService.findAllPreferences();
		return preferences.stream().filter(pref -> pref.getpId().getmuser_id()==id).collect(Collectors.toList());
	}
	
	@PostMapping(value="/users",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MUser addMUser(@RequestBody MUser m) {
		locationService.addLocation(m.getLocation());
		return mUserService.addMUser(m);
	}
	
	@PostMapping(value="/locations",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Location addLocation(@RequestBody Location l) {
		return locationService.addLocation(l);
	}
	
	@PostMapping(value="/preferences",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Preference addPreference(@RequestBody Preference p) {
		return preferenceService.addPreference(p);
	}
	
	@PutMapping(value="/preferences/add/{id}/{pLevel}/{genre}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Preference addPreferencePath(@PathVariable("id") int id, @PathVariable("pLevel") int pLevel, @PathVariable("genre") String genre) {
		Preference p = new Preference(new PreferenceId(id,pLevel),genre);
		return preferenceService.addPreference(p);
	}
	
	@PutMapping(value="/users",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MUser updateUser(@RequestBody MUser m) {
		return mUserService.updateMUser(m);
	}
	
	@PutMapping(value="/locations",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Location updateLocation(@RequestBody Location l) {
		return locationService.updateLocation(l);
	}
	
	@PutMapping(value="/preferences",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Preference updatePreference(@RequestBody Preference p) {
		return preferenceService.updatePreference(p);
	}
	
	@DeleteMapping(value="/users",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MUser deleteUser(@RequestBody MUser m) {
		return mUserService.deleteMUser(m);
	}
	
	@DeleteMapping(value="/locations",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Location deleteLocation(@RequestBody Location l) {
		return locationService.deleteLocation(l);
	}
	
	@DeleteMapping(value="/preferences",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Preference deletePreference(@RequestBody Preference p) {
		return preferenceService.deletePreference(p);
	}
	
	@GetMapping(value="/profile")
	@ResponseBody
	public MUser getProfile(HttpServletRequest request, HttpServletResponse response) {
		HttpSession s = request.getSession();
		int id= Integer.parseInt(s.getAttribute("id").toString());
		return mUserService.findMUserById(id);
	}
	
	@GetMapping(value="/session")
	@ResponseBody
	public MUser session(HttpServletRequest request, HttpServletResponse response) {
		HttpSession s = request.getSession(false);
		return mUserService.findMUserById(Integer.parseInt(s.getAttribute("id").toString()));
	}
	
	@GetMapping(value="/logins/{id}")
	@ResponseBody
	public MUser loggedInMUser(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		MUser u = mUserService.findMUserById(id);
		HttpSession s = request.getSession();
		s.setAttribute("email", u.getEmail());
		s.setAttribute("firstName",u.getFirstName());
		s.setAttribute("lastName", u.getLastName());
		s.setAttribute("aboutMe", u.getAboutMe());
		s.setAttribute("gender", u.getGender());
		s.setAttribute("id", u.getId());
		s.setAttribute("location", u.getLocation());
		s.setAttribute("orientation", u.getOrientation());
		s.setAttribute("password", u.getPassword());
		s.setAttribute("phoneNumber", u.getPhoneNumber());
		s.setAttribute("pictureUrl", u.getPictureUrl());
		s.setAttribute("prefs", u.getPrefs());
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("Http://192.168.61.203:4200/profile");
//		try {
//			rd.forward(request, response);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return mUserService.findMUserById(id);
	}
	
	@GetMapping(value="/users/genre/{genre}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MUser> getMUsersByGenre(@PathVariable("genre") String genre) {
		return mUserService.findMUserByGenre(genre);
	}
	
	@GetMapping(value="/users/match/{one}/{two}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public float getMatchScore(@PathVariable("one") int one, @PathVariable("two") int two) {
		return mUserService.matchTwoUsers(mUserService.findMUserById(one), mUserService.findMUserById(two));
	}
}
