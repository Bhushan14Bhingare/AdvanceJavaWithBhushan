package com.bhushan.blc.employee;


public class Employee {
       
		private int id;
        private String name;
        private int age;
        private double salary;
        
		public Employee(int id, String name, int age, double salary) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public double getSalary() {
			return salary;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
        
        
        
        
}
