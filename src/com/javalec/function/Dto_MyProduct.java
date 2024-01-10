package com.javalec.function;

public class Dto_MyProduct {

	int price;
	String nickname;
	String title;
	String post_status;
	int chat;
	int like;

	public Dto_MyProduct() {

	}
	
	public Dto_MyProduct(String post_status, String title, int price, String nickname) {
		this.post_status = post_status;
		this.title = title;
		this.price = price;
		this.nickname = nickname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getPost_status() {
		return post_status;
	}

	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}

	public int getChat() {
		return chat;
	}

	public void setChat(int chat) {
		this.chat = chat;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	
	
	
	

}
