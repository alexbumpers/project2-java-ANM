package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PreferenceId implements Serializable{
	@ManyToOne
	@JoinColumn(name="MUSER_ID")
	protected int muserId;
	@Column(name="PREF_LEVEL")
	protected int prefLevel;
	
	
	

	public PreferenceId() {
		super();
		}
	public PreferenceId(int muserId, int prefLevel) {
		super();
		this.muserId = muserId;
		this.prefLevel = prefLevel;
	}
	@Override
	public String toString() {
		return "PreferenceId [muserId=" + muserId + ", prefLevel=" + prefLevel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + muserId;
		result = prime * result + prefLevel;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreferenceId other = (PreferenceId) obj;
		if (muserId != other.muserId)
			return false;
		if (prefLevel != other.prefLevel)
			return false;
		return true;
	}
	public int getMuserId() {
		return muserId;
	}
	public void setMuserId(int muserId) {
		this.muserId = muserId;
	}
	public int getPrefLevel() {
		return prefLevel;
	}
	public void setPrefLevel(int prefLevel) {
		this.prefLevel = prefLevel;
	}
	
	
}
