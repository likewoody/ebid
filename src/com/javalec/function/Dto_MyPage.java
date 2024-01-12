package com.javalec.function;

public class Dto_MyPage {
	
	String userid;
	String pw;
	String phone;
	String email;
	String nickname;
	String address;
	String join_date;
	String delect_date;
	byte[] profileimage;
	
	public Dto_MyPage() {
		
	}

	public Dto_MyPage(String userid, String pw, String phone, String email, String nickname, String address) {
		this.userid = userid;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.nickname = nickname;
		this.address = address;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public String getDelect_date() {
		return delect_date;
	}

	public void setDelect_date(String delect_date) {
		this.delect_date = delect_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getProfileimage() {
		return profileimage;
	}

	public void setProfileimage(byte[] profileimage) {
		this.profileimage = profileimage;
	}
	
	
	
	

}
