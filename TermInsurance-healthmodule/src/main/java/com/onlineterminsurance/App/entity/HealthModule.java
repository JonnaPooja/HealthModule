package com.onlineterminsurance.App.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "healthmodule")
public class HealthModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer medicalId;
	private String aadharNo;
	private String name;
	private String address;
	private String phoneNo;
	private int age;
	public HealthModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HealthModule(Integer medicalId, String aadharNo, String name, String address, String phoneNo,int age) {
		super();
		this.medicalId = medicalId;
		this.aadharNo = aadharNo;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.age = age;
	}
	@Column(name = "Medical_Id",nullable=false)
	public Integer getMedicalId() {
		return medicalId;
	}
	public void setMedicalId(Integer medicalId) {
		this.medicalId = medicalId;
	}
	@Column(name = "Aadhar_No",nullable=false)
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	@Column(name = "Name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "Address",nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "Phone_No",nullable=false)
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Column(name = "Age",nullable=false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "HealthModule [medicalId=" + medicalId + ", aadharNo=" + aadharNo + ", name=" + name + ", address="
				+ address + ", phoneNo=" + phoneNo + ", age=" + age + "]";
	}
}