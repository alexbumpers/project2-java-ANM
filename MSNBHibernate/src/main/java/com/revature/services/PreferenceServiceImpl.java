package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Preference;
import com.revature.models.PreferenceId;
import com.revature.repositories.PreferenceRepository;

@Service
public class PreferenceServiceImpl implements PreferenceService {

	@Autowired
	PreferenceRepository prefRepo;
	
	@Override
	public List<Preference> findAllPreferences() {
		return prefRepo.findAll();
	}

	@Override
	public Preference findPreferenceByKey(PreferenceId pId) {
		return prefRepo.getOne(pId);
	}

	@Override
	public Preference addPreference(Preference newPreference) {
		return prefRepo.save(newPreference);
	}

	@Override
	public Preference updatePreference(Preference preference) {
		return prefRepo.save(preference);
	}

	@Override
	public Preference deletePreference(Preference preference) {
		prefRepo.delete(preference);
		return preference;
	}
	
	@Override
	public List<Preference> findPreferencesByGenre(String genre){
		return prefRepo.findPreferencesByGenre(genre);
	}

}
