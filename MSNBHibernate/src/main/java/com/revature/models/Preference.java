package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity(name="Preference")
@Table(name="preference")
//@IdClass(PreferenceId.class)
@Check(constraints = "PREF_LEVEL < 11")
public class Preference implements Serializable{
	
//	@EmbeddedId
//	private PreferenceId id;
//	
	@Id
	@Column(name="MUSER_ID")
	protected int muserId;
	@Id
	@Column(name="PREF_LEVEL", columnDefinition="NUMBER(2,0)")
	protected int prefLevel;
	
	@Column(name="GENRE")
	private String genre;
	
	
	
}