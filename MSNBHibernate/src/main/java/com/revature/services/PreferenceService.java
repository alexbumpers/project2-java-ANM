package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.Preference;
import com.revature.models.PreferenceId;

public interface PreferenceService {
	public List<Preference> findAllPreferences();
	public Preference findPreferenceByKey(PreferenceId pId);
	public Preference addPreference(Preference newPreference);
	public Preference updatePreference(Preference preference);
	public Preference deletePreference(Preference preference);
}
