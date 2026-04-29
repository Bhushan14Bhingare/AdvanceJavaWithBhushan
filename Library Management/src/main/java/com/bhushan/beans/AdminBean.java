package com.bhushan.beans;

public class AdminBean {

	private String username;
	private String password;
	private String first;
	private String last;
	private String mail;
	private String phone;
	
	
	public AdminBean(String username, String password, String first, String last, String mail, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.first = first;
		this.last = last;
		this.mail = mail;
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getLast() {
		return last;
	}


	public void setLast(String last) {
		this.last = last;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
