package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User 
{

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String city;
	private String email;
	private String mobileNumber;
	
	
	Connection con =null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
			

//	public User(String firstName, String lastName, String userName, String password, String city, String email,
//			String mobleNumber) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userName = userName;
//		this.password = password;
//		this.city = city;
//		this.email = email;
//		this.mobileNumber = mobileNumber;
//	}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobleNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", city=" + city + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
	
	
	
	
	
}
