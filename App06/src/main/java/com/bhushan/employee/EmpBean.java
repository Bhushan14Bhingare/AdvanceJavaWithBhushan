package com.bhushan.employee;

import java.io.Serializable;

public class EmpBean implements Serializable{
	
	private String emp_id;
	private String emp_first;
	private String emp_last;
	private int emp_sal;
	private String emp_add;

	
	public EmpBean() {
		
	}


	public String getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}


	public String getEmp_first() {
		return emp_first;
	}


	public void setEmp_first(String emp_first) {
		this.emp_first = emp_first;
	}


	public String getEmp_last() {
		return emp_last;
	}


	public void setEmp_last(String emp_last) {
		this.emp_last = emp_last;
	}


	public int getEmp_sal() {
		return emp_sal;
	}


	public void setEmp_sal(int emp_sal) {
		this.emp_sal = emp_sal;
	}


	public String getEmp_add() {
		return emp_add;
	}


	public void setEmp_add(String emp_add) {
		this.emp_add = emp_add;
	}


	@Override
	public String toString() {
		return ""+ emp_id + " " + emp_first + " " + emp_last + " "
				+ emp_sal + " " + emp_add ;
	}
	
	
}
