package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.MUser;
import com.revature.models.Preference;
import com.revature.repositories.MUserRepository;
import com.revature.repositories.PreferenceRepository;

@Service
public class MUserServiceImpl implements MUserService {

	@Autowired
	MUserRepository mUserRepo;
	
	@Autowired
	PreferenceRepository prefRepo;
	
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
	public List<MUser> findByFirstName(String firstName) {
		return mUserRepo.findByFirstNameIgnoreCaseStartingWith(firstName);
	}

	@Override
	public MUser login(String email, String password) {
		return mUserRepo.findMUserByEmailAndPassword(email, password);
	}

	@Override
	public List<MUser> findMUserByGenre(String gVar){
		List<MUser> m = new ArrayList<>();
		List<Preference> p = prefRepo.findPreferencesByGenre(gVar);
		
		for(Preference pref: p) {
			m.add(mUserRepo.getOne(pref.getpId().getmuser_id()));
		}
		return m;
	}

	@Override
	public MUser findMUserByUsername(String email) {
		return mUserRepo.getMUserByEmail(email);
	}
	@Override
	public float matchTwoUsers(MUser one, MUser two) {
		float score = 0.0F;
		for(Preference p: one.getPrefs()) {
			for(Preference t: two.getPrefs()) {
				if(p.getGenre().equals(t.getGenre())) {
					score += (11-p.getpId().getpLevel())+(11-t.getpId().getpLevel());
				}
			}
		}
		return score/1.1F;
	}


}
