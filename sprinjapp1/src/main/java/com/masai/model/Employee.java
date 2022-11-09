package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empld;
	
	@ Size(min =3,max= 20, message ="Name size must be in min 3 and max 20")
	private String empName;
	@NotNull(message ="name should be mandatory")
	@Max(value = 100000, message ="salary should not be greater than 100000")
	private Integer salary;
	@NotNull(message ="address should be mandatory")
	private String address;
	
	@NotNull(message ="email should be mandatory")
	@Email(message = "email should be in correct format")
	private String email;
	
	@NotNull(message ="mobile should be mandatory")
	private String mobile;
	
	public Employee() {
		
	}
	
	public Employee(Integer empld, String empName, Integer salary, String address, String email, String mobile) {
		super();
		this.empld = empld;
		this.empName = empName;
		this.salary = salary;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}

	public Integer getEmpld() {
		return empld;
	}

	public void setEmpld(Integer empld) {
		this.empld = empld;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [empld=" + empld + ", empName=" + empName + ", salary=" + salary + ", address=" + address
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
	
	
	
	
}
