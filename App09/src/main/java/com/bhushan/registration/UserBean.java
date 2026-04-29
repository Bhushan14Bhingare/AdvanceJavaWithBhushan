package com.bhushan.registration;

import java.util.Arrays;

public class UserBean {
  private String name;
  private String age;
  private String gender;
  private String address;
  private String marital;
  private String qualifcation;
  private String course;
  private String[] hobies;
  
  
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getAge() {
	return age;
  }
  public void setAge(String age) {
	this.age = age;
  }
  public String getGender() {
	return gender;
  }
  public void setGender(String gender) {
	this.gender = gender;
  }
  public String getAddress() {
	return address;
  }
  public void setAddress(String address) {
	this.address = address;
  }
  public String getMarital() {
	return marital;
  }
  public void setMarital(String marital) {
	this.marital = marital;
  }
  public String getQualifcation() {
	return qualifcation;
  }
  public void setQualifcation(String qualifcation) {
	this.qualifcation = qualifcation;
  }
  public String getCourse() {
	return course;
  }
  public void setCourse(String course) {
	this.course = course;
  }
  public String[] getHobies() {
	return hobies; 
  }
  public void setHobies(String[] parameterValues) {
	this.hobies = parameterValues;
	
  }
   
  @Override
  public String toString() {
	return ""+ name + " " + age + " " + gender + " " + address + " "
			+ marital + " " + qualifcation + " " + course + " " + Arrays.toString(hobies)
			;
  }
  
 
  
  
  
}
