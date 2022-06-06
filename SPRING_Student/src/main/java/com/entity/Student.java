package com.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull
	@Column(name = "lastName")
	private String lastName;

	@NotNull
	@Column(name = "email", unique = true)
	private String email;

	@NotNull
	@Column(name = "phone")
	private String phone;

	@NotNull
	@Column(name = "address")
	private String address;

	@NotNull
	@Column(name = "city")
	private String city;

	@NotNull
	@Column(name = "studyYear")
	private int studyYear;
	
	@NotNull
	@Column(name = "age")
	private int age;
	
	public Student() {}

	public Student(@NotNull String firstName, @NotNull String lastName, @NotNull String email,
			@NotNull String phone, @NotNull String address, @NotNull String city, int studyYear,
			int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.studyYear = studyYear;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", city=" + city + ", studyYear=" + studyYear + ", age="
				+ age + "]";
	}
	
	
	
}
