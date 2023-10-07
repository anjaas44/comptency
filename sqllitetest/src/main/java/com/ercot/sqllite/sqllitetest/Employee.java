package com.ercot.sqllite.sqllitetest;

public class Employee
{
	
	int id;
	String firstName;
	String lastName;
	String emailAddress;
	String phoneNumner;
	public synchronized int getId() {
		return id;
	}
	public synchronized void setId(int id) {
		this.id = id;
	}
	public synchronized String getFirstName() {
		return firstName;
	}
	public synchronized void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public synchronized String getLastName() {
		return lastName;
	}
	public synchronized void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public synchronized String getEmailAddress() {
		return emailAddress;
	}
	public synchronized void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public synchronized String getPhoneNumner() {
		return phoneNumner;
	}
	public synchronized void setPhoneNumner(String phoneNumner) {
		this.phoneNumner = phoneNumner;
	}
	

}
