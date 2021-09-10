package com.customer.vo;

public class Customer {
	private String num;
	private String name;
	private String address;
	private String email;
	private String tel;
	private int interest;
	
	public Customer() {}
	
	public Customer(String num, String name, String address, String email, String tel, int interest) {		
		this.num = num;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.interest = interest;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", address=" + address + ", email=" + email + ", tel=" + tel
				+ ", interest=" + interest + "]";
	}
	
	
}
