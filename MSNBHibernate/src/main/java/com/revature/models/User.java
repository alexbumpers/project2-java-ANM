package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class User {
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
		@SequenceGenerator(name="userSequence",allocationSize=1,sequenceName="SQ_USER_PK")
		@Column(name="USER_ID")
		private int id;
		@Column(name="FIRST_NAME")
		private String firstName;
		@Column(name="LAST_NAME")
		private String lastName;
		@Column(name="PASSWORD")
		private String password;
		@Column(name="EMAIL")
		private String email;
		@Column(name="PHONE_NUMBER")
		private String phoneNumber;
		@Column(name="ABOUT_ME")
		private String aboutMe;
		@ManyToOne
		@JoinColumn(name="LOCATAION_ID")
		private int loc_id;
		
		//some kind of implementation for user song preferences.
		
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(int id, String firstName, String lastName, String password, String email, String phoneNumber,
				String aboutMe, int loc_id) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.aboutMe = aboutMe;
			this.loc_id = loc_id;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
					+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", aboutMe=" + aboutMe + ", loc_id="
					+ loc_id + "]";
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
			result = prime * result + loc_id;
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
			User other = (User) obj;
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
			if (loc_id != other.loc_id)
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
		public int getLoc_id() {
			return loc_id;
		}
		public void setLoc_id(int loc_id) {
			this.loc_id = loc_id;
		}

}
