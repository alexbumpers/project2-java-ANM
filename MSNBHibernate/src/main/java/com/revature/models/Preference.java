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
	
	@Column(name="GENRE", columnDefinition="VARCHAR2(30)")
	private String genre;

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
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
		Preference other = (Preference) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (muserId != other.muserId)
			return false;
		if (prefLevel != other.prefLevel)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Preference [muserId=" + muserId + ", prefLevel=" + prefLevel + ", genre=" + genre + "]";
	}

	public Preference(int muserId, int prefLevel, String genre) {
		super();
		this.muserId = muserId;
		this.prefLevel = prefLevel;
		this.genre = genre;
	}

	public Preference() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}