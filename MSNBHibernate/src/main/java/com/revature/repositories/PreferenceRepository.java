package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Preference;
import com.revature.models.PreferenceId;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference,PreferenceId> {

}
