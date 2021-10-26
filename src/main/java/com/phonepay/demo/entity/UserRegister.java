package com.phonepay.demo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class UserRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRegisterId;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	//private User user;
	
	

	/*public UserRegister(int userRegisterId, String firstName, String lastName, String mobileNumber,User user) {
		super();
		this.userRegisterId = userRegisterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.user = user;
	}*/

	public int getUserRegisterId() {
		return userRegisterId;
	}

	/*public UserRegister() {
		super();
	}*/

	public void setUserRegisterId(int userRegisterId) {
		this.userRegisterId = userRegisterId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
