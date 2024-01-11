package com.javalec.function;

public class Dto_Write {
	
	String userid;
	String pw;
	
	
	
	public Dto_Write() {
		
	}

	
	public Dto_Write(String userid, String pw) {
		super();
		this.userid = userid;
		this.pw = pw;
	}
	
	// 생성자를 Dao Class 로 보내주기 위하여 Getter, Setter 를 사용한다.

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	

}
