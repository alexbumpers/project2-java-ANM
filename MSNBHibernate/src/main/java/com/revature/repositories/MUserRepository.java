package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.MUser;

@Repository
public interface MUserRepository extends JpaRepository<MUser,Integer>{
	public MUser findMUserByEmailAndPassword(String email, String password);
}