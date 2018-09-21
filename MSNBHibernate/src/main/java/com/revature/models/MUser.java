package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class MUser {
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mUserSequence")
		@SequenceGenerator(name="mUserSequence",allocationSize=1,sequenceName="SQ_MUSER_PK")
		@Column(name="MUSER_ID")
		private int id;
		@Column(name="FIRST_NAME", columnDefinition="VARCHAR2(50)")
		private String firstName;
		@Column(name="LAST_NAME", columnDefinition="VARCHAR2(50)")
		private String lastName;
		@Column(name="PASSWORD", columnDefinition="VARCHAR2(24)")
		private String password;
		@Column(name="EMAIL", unique=true)
		private String email;
		@Column(name="PHONE_NUMBER")
		private String phoneNumber;
		@Column(name="ABOUT_ME", columnDefinition="VARCHAR(max)")
		private String aboutMe;
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="LOCATION_ID")
		private Location location;
		@OneToMany(fetch=FetchType.EAGER)
		@JoinColumn(name="MUSER_ID")
		private List<Preference> prefs;
		@Column(name="GENDER", columnDefinition="char(1)")
		private String gender;
		@Column(name="PROF_PIC")
		private String pictureUrl;
		public List<Preference> getPrefs() {
			return prefs;
		}
		public void setPrefs(List<Preference> prefs) {
			this.prefs = prefs;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getOrientation() {
			return orientation;
		}
		public void setOrientation(String orientation) {
			this.orientation = orientation;
		}
		@Column(name="ORIENTATION", columnDefinition="varchar2(20)")
		private String orientation;
		
		//some kind of implementation for user song preferences.
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAboutMe() {
			return aboutMe;
		}
		public void setAboutMe(String aboutMe) {
			this.aboutMe = aboutMe;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((aboutMe == null) ? 0 : aboutMe.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + id;
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((location == null) ? 0 : location.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
			MUser other = (MUser) obj;
			if (aboutMe == null) {
				if (other.aboutMe != null)
					return false;
			} else if (!aboutMe.equals(other.aboutMe))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (location == null) {
				if (other.location != null)
					return false;
			} else if (!location.equals(other.location))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (phoneNumber == null) {
				if (other.phoneNumber != null)
					return false;
			} else if (!phoneNumber.equals(other.phoneNumber))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "MUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
					+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", aboutMe=" + aboutMe + ", location="
					+ location + ", prefs=" + prefs + ", gender=" + gender + ", orientation=" + orientation + "]";
		}
		public MUser(int id, String firstName, String lastName, String password, String email, String phoneNumber,
				String aboutMe, Location location) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.aboutMe = aboutMe;
			this.location = location;
		}
		public MUser() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
}
