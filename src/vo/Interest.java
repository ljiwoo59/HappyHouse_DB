package com.customer.vo;

public class Interest {
	private String num;
	private String dongcode;
	private String city;
	private String gugun;
	private String dong;
	
	public Interest() {}
	
	public Interest(String num, String dongcode, String city, String gugun, String dong) {
		super();
		this.num = num;
		this.dongcode = dongcode;
		this.city = city;
		this.gugun = gugun;
		this.dong = dong;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	
	@Override
	public String toString() {
		return "Interest [num=" + num + ", dongcode=" + dongcode + ", city=" + city + ", gugun=" + gugun + ", dong="
				+ dong + "]";
	}
	

}
