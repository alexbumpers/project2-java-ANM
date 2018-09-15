package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public int createUser(User u);
	public void updateUser(User u);
	public void deleteUser(int id);
	public List<User> findUsersByLocId(int i);
	public long getUserCount();

}
