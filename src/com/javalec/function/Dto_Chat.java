package com.javalec.function;

import java.sql.Date;

public class Dto_Chat {
	
	private byte[] profile_image;
	private String nickname;
	private String title;
	private Date chatDate;
	private int chatId;
	private String detailtext;
	private byte[] detailtextImage;
	private Date detailDate;
	private String detailUser;
	private int sellId;
	private String sellUser;
	private String chatUser;
	
	public Dto_Chat() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Dto_Chat(String deatilUser) {
		this.detailUser = deatilUser;
	}

	public Dto_Chat(byte[] profile_image, int sellId) {
		this.profile_image = profile_image;
		this.sellId = sellId;
	}
	
	public Dto_Chat(byte[] profile_image, String sellUser) {
		this.profile_image = profile_image;
		this.sellUser = sellUser;
	}

//	public Dto_Chat(String detailtext, Date detailDate, String detailUser) {
//		this.detailtext = detailtext;
//		this.detailDate = detailDate;
//		this.detailUser = detailUser;
//	}
	


	public Dto_Chat(byte[] profile_image, String detailtext, Date detailDate, String detailUser) {
		this.profile_image = profile_image;
		this.detailtext = detailtext;
		this.detailDate = detailDate;
		this.detailUser = detailUser;
	}
	
	
	public Dto_Chat(byte[] profile_image, byte[] detailtextImage, Date detailDate, String detailUser) {
		this.profile_image = profile_image;
		this.detailtextImage = detailtextImage;
		this.detailDate = detailDate;
		this.detailUser = detailUser;
	}


	public Dto_Chat(byte[] profile_image, String nickname, String title, Date chatDate, int chatId, String chatUser, String sellUser) {
		this.profile_image = profile_image;
		this.nickname = nickname;
		this.title = title;
		this.chatDate = chatDate;
		this.chatId = chatId;
		this.chatUser = chatUser;
		this.sellUser = sellUser;
	}
//	public Dto_Chat(byte[] profile_image, String nickname, String title, int chatDate) {
//		this.profile_image = profile_image;
//		this.nickname = nickname;
//		this.title = title;
//		this.chatDate = chatDate;
//}	




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




	public Date getChatDate() {
		return chatDate;
	}




	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}




	public int getChatId() {
		return chatId;
	}




	public void setChatId(int chatId) {
		this.chatId = chatId;
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




	public int getSellId() {
		return sellId;
	}




	public void setSellId(int sellId) {
		this.sellId = sellId;
	}




	public String getSellUser() {
		return sellUser;
	}




	public void setSellUser(String sellUser) {
		this.sellUser = sellUser;
	}




	public String getChatUser() {
		return chatUser;
	}




	public void setChatUser(String chatUser) {
		this.chatUser = chatUser;
	}




	public byte[] getDetailtextImage() {
		return detailtextImage;
	}




	public void setDetailtextImage(byte[] detailtextImage) {
		this.detailtextImage = detailtextImage;
	}
	
	
	
}
