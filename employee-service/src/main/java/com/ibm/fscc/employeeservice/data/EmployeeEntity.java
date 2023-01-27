package com.ibm.fscc.employeeservice.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class EmployeeEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; // primary and generated
	@Column(name = "userId", unique = true, nullable = false)
	private String userId; // Generate with UUID and unique
	

	@Column(name = "firstname")
	private String firstName; 
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "address")
	private String address; 
	@Column(name = "city")
	private String city;
	@Column( name = "state")
	private String state;
	@Column(name = "zip")
	private String zip;
	@Column(name = "cell")
	private String cellPhone;
	@Column(name = "landline")
	private String homePhone;
	@Column(name = "email")
	private String email; // Unique

	public EmployeeEntity(){

	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	@PrePersist
	protected void uniqueID(){
		this.setUserId(java.util.UUID.randomUUID().toString());
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String state) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
