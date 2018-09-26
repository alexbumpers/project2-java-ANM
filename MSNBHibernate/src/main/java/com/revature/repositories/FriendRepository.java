package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
	public List<Friend> getFriendsByPerson(int person);
	public List<Friend> getFriendsByIsFriendsWith(int isFriendsWith);
}
