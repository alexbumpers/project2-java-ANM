package com.revature.daos;

import java.util.List;

import com.revature.models.MUser;

public interface UserDao {
	public List<MUser> getUsers();
	public MUser getUserById(int id);
	public int createUser(MUser u);
	public void updateUser(MUser u);
	public void deleteUser(int id);
	public List<MUser> findUsersByLocId(int i);
	public long getUserCount();
	public MUser getUserByEmailPass(String email, String pass);
}
