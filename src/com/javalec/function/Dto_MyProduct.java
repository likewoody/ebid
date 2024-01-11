package com.javalec.function;

public class Dto_MyProduct {

	int price;
	int postid;
	String nickname;
	String title;
	String post_status;
	int count;

	public Dto_MyProduct() {

	}
	
	public Dto_MyProduct(int count) {
		this.count = count;
	}
	
	public Dto_MyProduct(int postid, String post_status, String title, int price, String nickname) {
		this.postid = postid;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	
	
	

}
