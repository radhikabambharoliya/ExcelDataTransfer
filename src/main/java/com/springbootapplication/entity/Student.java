package com.springbootapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student1")
public class Student {
     
	 @Id
	 private int no;
	
	 private String name;
	
	 private int phone;
	 
	 private String address;

	 public int getNo() {
		 return no;
	 }

	 public void setNo(int no) {
		 this.no = no;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public int getPhone() {
		 return phone;
	 }

	 public void setPhone(int phone) {
		 this.phone = phone;
	 }

	 
	 public String getAddress() {
		 return address;
	 }

	 public void setAddress(String address) {
		 this.address = address;
	 }

	 public Student(int no, String name, int phone, String address) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
	 }
	 public Student() {
		 
	 }
}
