package com.javalec.function;

import javax.swing.ImageIcon;

import com.mysql.cj.jdbc.Blob;

public class Dto_Home {
	
	byte[] post_image;
	String title; // 포스트 제목
	int start_price;
	String nickname;
	String sort;
	
	public Dto_Home() {
		// TODO Auto-generated constructor stub
	}
	
	public Dto_Home(byte[] post_image, String title, int start_price, String nickname, String sort) {
		this.post_image = post_image;
		this.title = title;
		this.start_price = start_price;
		this.nickname = nickname;
		this.sort = sort;
	}

	public byte[] getPost_image() {
		return post_image;
	}

	public void setPost_image(byte[] post_image) {
		this.post_image = post_image;
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

}
