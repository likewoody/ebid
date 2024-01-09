package com.javalec.function;

import javax.swing.ImageIcon;

public class Dto_Home {
	
	int postId;
	byte[] post_image;
	byte[] user_image;
	String title; // 포스트 제목
	int start_price;
	String nickname;
	String sort;
	int wishListCount;
	int chatCount;
	String desc;
//	double rating;
	
	public Dto_Home() {
		// TODO Auto-generated constructor stub
	}
	
	public Dto_Home(byte[] post_image) {
		this.post_image = post_image;
	}
	
	public Dto_Home(byte[] user_image, String nickname) {
		this.user_image = user_image;
		this.nickname = nickname;
	}
	
//	public Dto_Home(byte[] user_image, String nickname, double rating) {
//		this.user_image = user_image;
//		this.nickname = nickname;
//		this.rating = rating;
//	}
	
	public Dto_Home(String title, String nickname, String desc, int start_price) {
		this.title = title;
		this.nickname = nickname;
		this.desc = desc;
		this.start_price = start_price;
	}
	
	public Dto_Home(byte[] post_image, String title, int start_price, String sort, String nickname) {
		this.post_image = post_image;
		this.title = title;
		this.start_price = start_price;
		this.sort = sort;
		this.nickname = nickname;
	}


	public Dto_Home(byte[] post_image, String title, int start_price, String nickname, String sort, int postId, int wishListCount, int chatCount) {
		this.post_image = post_image;
		this.title = title;
		this.start_price = start_price;
		this.nickname = nickname;
		this.sort = sort;
		this.postId = postId;
		this.wishListCount = wishListCount;
		this.chatCount = chatCount;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public byte[] getPost_image() {
		return post_image;
	}

	public void setPost_image(byte[] post_image) {
		this.post_image = post_image;
	}

	public byte[] getUser_image() {
		return user_image;
	}

	public void setUser_image(byte[] user_image) {
		this.user_image = user_image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStart_price() {
		return start_price;
	}

	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getWishListCount() {
		return wishListCount;
	}

	public void setWishListCount(int wishListCount) {
		this.wishListCount = wishListCount;
	}

	public int getChatCount() {
		return chatCount;
	}

	public void setChatCount(int chatCount) {
		this.chatCount = chatCount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
