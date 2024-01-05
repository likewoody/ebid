package com.javalec.function;

public class Dto_Home {
	
	 
	String text;
	String option; // 경매인지 일반판매인지
	String user_nickname; // user_nickname
	String post_image; // post_image file_name
	String user_image;
	String file;
	int price;
	
	int winning_price;
	int postid;
	int chat_count;
	int wishlist_count;
	int action_date;
	int seq;
	
	String bid_status;
	String post_title; // 포스트 제목
	int start_price;
	String nickname;
	
	
	public Dto_Home() {
		// TODO Auto-generated constructor stub
	}
	

	public Dto_Home(int seq, String file) {
		this.seq = seq;
		this.file = file;
	}
	

	public Dto_Home(String bid_status, String post_title, int start_price, String nickname) {
		this.bid_status = bid_status;
		this.post_title = post_title;
		this.start_price = start_price;
		this.nickname = nickname;
	}


	public Dto_Home(String post_title, String text, String option, String user_nickname, String post_image,
			String user_image, String file, int price, int start_price, int winning_price, int postid, int chat_count,
			int wishlist_count, int action_date, int seq) {
		this.post_title = post_title;
		this.text = text;
		this.option = option;
		this.user_nickname = user_nickname;
		this.post_image = post_image;
		this.user_image = user_image;
		this.file = file;
		this.price = price;
		this.start_price = start_price;
		this.winning_price = winning_price;
		this.postid = postid;
		this.chat_count = chat_count;
		this.wishlist_count = wishlist_count;
		this.action_date = action_date;
		this.seq = seq;
	}




	public String getPost_title() {
		return post_title;
	}


	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getOption() {
		return option;
	}


	public void setOption(String option) {
		this.option = option;
	}


	public String getUser_nickname() {
		return user_nickname;
	}


	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}


	public String getPost_image() {
		return post_image;
	}


	public void setPost_image(String post_image) {
		this.post_image = post_image;
	}


	public String getUser_image() {
		return user_image;
	}


	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getStart_price() {
		return start_price;
	}


	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}


	public int getWinning_price() {
		return winning_price;
	}


	public void setWinning_price(int winning_price) {
		this.winning_price = winning_price;
	}


	public int getPostid() {
		return postid;
	}


	public void setPostid(int postid) {
		this.postid = postid;
	}


	public int getChat_count() {
		return chat_count;
	}


	public void setChat_count(int chat_count) {
		this.chat_count = chat_count;
	}


	public int getWishlist_count() {
		return wishlist_count;
	}


	public void setWishlist_count(int wishlist_count) {
		this.wishlist_count = wishlist_count;
	}


	public int getAction_date() {
		return action_date;
	}


	public void setAction_date(int action_date) {
		this.action_date = action_date;
	}
	
	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
	

}
