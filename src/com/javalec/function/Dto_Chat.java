package com.javalec.function;

public class Dto_Chat {
	
	private byte[] profile_image;
	private String nickname;
	private String title;
	private int chatDate;
	
	public Dto_Chat() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Dto_Chat(byte[] profile_image, String nickname, String title) {
		this.profile_image = profile_image;
		this.nickname = nickname;
		this.title = title;
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
	
	
	
}
