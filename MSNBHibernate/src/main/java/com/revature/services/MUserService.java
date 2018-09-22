package com.revature.services;

import java.util.List;

import com.revature.models.MUser;

public interface MUserService {
	public List<MUser> findAllMUsers();
	public MUser findMUserById(int id);
	public MUser addMUser(MUser newMUser);
	public MUser updateMUser(MUser mUser);
	public MUser deleteMUser(MUser mUser);
	public MUser login(String email, String password);
	List<MUser> findMUserByGenre(String gVar);
}
