package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.MUser;
import com.revature.repositories.MUserRepository;

@Service
public class MUserServiceImpl implements MUserService {

	@Autowired
	MUserRepository mUserRepo;
	@Override
	public List<MUser> findAllMUsers() {
		return mUserRepo.findAll();
	}

	@Override
	public MUser findMUserById(int id) {
		return mUserRepo.getOne(id);
	}

	@Override
	public MUser addMUser(MUser newMUser) {
		return mUserRepo.save(newMUser);
	}

	@Override
	public MUser updateMUser(MUser mUser) {
		return mUserRepo.save(mUser);
	}

	@Override
	public MUser deleteMUser(MUser mUser) {
		mUserRepo.delete(mUser);
		return mUser;
	}

	@Override
	public MUser login(String email, String password) {
		return mUserRepo.findMUserByEmailAndPassword(email, password);
	}

}
