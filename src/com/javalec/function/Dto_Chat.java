package com.javalec.function;

public class Dto_Chat {
	
	private byte[] profile_image;
	private String nickname;
	private String title;
	private int chatDate;
	private int chatid;
	private String detailtext;
	private String detailuserid;
	private int detailDate;
	private String deatilUser;
	
	
	public Dto_Chat() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Dto_Chat(String deatilUser) {
		this.deatilUser = deatilUser;
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
	
	
	public Dto_Chat(String detailtext, String detailuserid, int detailDate) {
		super();
		this.detailtext = detailtext;
		this.detailuserid = detailuserid;
		this.detailDate = detailDate;
	}



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



	public String getDetailuserid() {
		return detailuserid;
	}



	public void setDetailuserid(String detailuserid) {
		this.detailuserid = detailuserid;
	}



	public int getDetailDate() {
		return detailDate;
	}



	public void setDetailDate(int detailDate) {
		this.detailDate = detailDate;
	}
	
	
}
