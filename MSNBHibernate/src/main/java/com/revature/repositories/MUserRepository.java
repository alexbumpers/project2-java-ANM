package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.MUser;

@Repository
public interface MUserRepository extends JpaRepository<MUser,Integer>{
	public MUser findMUserByEmailAndPassword(String email, String password);

	public MUser getMUserByEmail(String email);
}