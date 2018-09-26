package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Friend;
import com.revature.repositories.FriendRepository;
@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendRepository frieRepo;
	@Override
	public List<Friend> findAllFriends() {
		return frieRepo.findAll();
	}
	
	@Override
	public List<Friend> findFriendsByPerson(int person){
		return frieRepo.getFriendsByPerson(person);
	}
	
	@Override
	public List<Friend> findFriendsByIsFriendsWith(int isFriendsWith){
		return frieRepo.getFriendsByIsFriendsWith(isFriendsWith);
	}

	@Override
	public Friend findFriendById(int id) {
		return frieRepo.getOne(id);
	}

	@Override
	public Friend addFriend(Friend newFriend) {
		return frieRepo.save(newFriend);
	}

	@Override
	public Friend updateFriend(Friend friend) {
		return frieRepo.save(friend);
	}

	@Override
	public Friend deleteFriend(Friend friend) {
		frieRepo.delete(friend);
		return friend;
	}

}
