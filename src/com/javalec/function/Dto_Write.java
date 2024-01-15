package com.javalec.function;

public class Dto_Write {
	
	String userid;
	String pw;	
	String title;
	String description;
	String post_status;
	String sort;
	String price;
	String view_count;
	String start_date;
	String postid;
	
	// 추가
	String nickname;
	String profile_image;
	String sellerImage;
	
	
		
	public Dto_Write() {
		
	}
	
	// 추가
	
	public Dto_Write(String userid, String postid, String nickname, String profile_image) {
		super();
		this.userid = userid;
		this.postid = postid;
		this.nickname = nickname;
		this.profile_image = profile_image;
	}




	public Dto_Write(String userid) {
		super();
		this.userid = userid;
	}



	public Dto_Write(String title, String description, String price) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
	}


	public Dto_Write(String title, String description, String post_status, String sort, String price, String view_count,
			String start_date, String postid) {
		super();
		this.title = title;
		this.description = description;
		this.post_status = post_status;
		this.sort = sort;
		this.price = price;
		this.view_count = view_count;
		this.start_date = start_date;
		this.postid = postid;
	}


	public Dto_Write(String userid, String pw) {
		super();
		this.userid = userid;
		this.pw = pw;
	}
	
	// 생성자를 Dao Class 로 보내주기 위하여 Getter, Setter 를 사용한다.

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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPost_status() {
		return post_status;
	}


	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getView_count() {
		return view_count;
	}


	public void setView_count(String view_count) {
		this.view_count = view_count;
	}


	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}


	public String getPostid() {
		return postid;
	}


	public void setPostid(String postid) {
		this.postid = postid;
	}
	// 추가

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getSellerImage() {
		return sellerImage;
	}

	public void setSellerImage(String sellerImage) {
		this.sellerImage = sellerImage;
	}
	
	
	
	
	
	
	

}
