package com.bhushan.registration;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	
	private String u_name;
	private String u_pwd;
	private String u_fname;
	private String u_lname;
	private String u_mail;
	private String u_phone;
	
	
	public UserBean() {
		super();
	}


	public String getU_name() {
		return u_name;
	}


	public void setU_name(String u_name) {
		this.u_name = u_name;
	}


	public String getU_pwd() {
		return u_pwd;
	}


	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}


	public String getU_fname() {
		return u_fname;
	}


	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}


	public String getU_lname() {
		return u_lname;
	}


	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}


	public String getU_mail() {
		return u_mail;
	}


	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}


	public String getU_phone() {
		return u_phone;
	}


	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}


	@Override
	public String toString() {
		return "UserBean [u_name=" + u_name + ", u_pwd=" + u_pwd + ", u_fname=" + u_fname + ", u_lname=" + u_lname
				+ ", u_mail=" + u_mail + ", u_phone=" + u_phone + "]";
	}
	
	

}
