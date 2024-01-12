package com.javalec.function;

public class Dto_MyProduct {

	String title;
	int price;
	String nick;
	String status;
	int postid;
	int sellid;
	int wish;
	int chat;
	byte[] postimage;

	public Dto_MyProduct() {

	}

	public Dto_MyProduct(byte[] postimage, String title, int price, String nick, String status, int postid,int sellid, int wish,
			int chat) {
		this.title = title;
		this.price = price;
		this.nick = nick;
		this.status = status;
		this.postid = postid;
		this.sellid = sellid;
		this.wish = wish;
		this.chat = chat;
		this.postimage = postimage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getWish() {
		return wish;
	}

	public void setWish(int wish) {
		this.wish = wish;
	}

	public int getChat() {
		return chat;
	}

	public void setChat(int chat) {
		this.chat = chat;
	}

	public byte[] getPostimage() {
		return postimage;
	}

	public void setPostimage(byte[] postimage) {
		this.postimage = postimage;
	}

	public int getSellid() {
		return sellid;
	}

	public void setSellid(int sellid) {
		this.sellid = sellid;
	}
	

}
