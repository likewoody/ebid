package com.javalec.function;

import java.sql.Date;

public class Dto_Chat {
	
	private byte[] profile_image;
	private String nickname;
	private String title;
	private int chatDate;
	private int chatid;
	private String detailtext;
	private Date detailDate;
	private String detailUser;
	
	
	public Dto_Chat() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Dto_Chat(String deatilUser) {
		this.detailUser = deatilUser;
	}


	public Dto_Chat(String detailtext, Date detailDate, String detailUser) {
		this.detailtext = detailtext;
		this.detailDate = detailDate;
		this.detailUser = detailUser;
	}


	public Dto_Chat(byte[] profile_image, String nickname, String title, int chatid) {
		this.profile_image = profile_image;
		this.nickname = nickname;
		this.title = title;
		this.chatid = chatid;
	}
//	public Dto_Chat(byte[] profile_image, String nickname, String title, int chatDate) {
//		this.profile_image = profile_image;
//		this.nickname = nickname;
//		this.title = title;
//		this.chatDate = chatDate;
//	}


	public byte[] getProfile_image() {
		return profile_image;
	}




	public void setProfile_image(byte[] profile_image) {
		this.profile_image = profile_image;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getChatDate() {
		return chatDate;
	}




	public void setChatDate(int chatDate) {
		this.chatDate = chatDate;
	}




	public int getChatid() {
		return chatid;
	}




	public void setChatid(int chatid) {
		this.chatid = chatid;
	}




	public String getDetailtext() {
		return detailtext;
	}




	public void setDetailtext(String detailtext) {
		this.detailtext = detailtext;
	}




	public Date getDetailDate() {
		return detailDate;
	}




	public void setDetailDate(Date detailDate) {
		this.detailDate = detailDate;
	}




	public String getDetailUser() {
		return detailUser;
	}




	public void setDetailUser(String detailUser) {
		this.detailUser = detailUser;
	}
	
}
