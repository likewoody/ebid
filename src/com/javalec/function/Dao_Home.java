package com.javalec.function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dao_Home {
	
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	
	String post_title;
	String text;
	String option;
	String user_nickname;
	String post_image;
	String user_image;
	String file;
	int price;
	int start_price;
	int winning_price;
	int postid;
	int chat_count;
	int wishlist_count;
	int action_date;
	int seq;
	
	
	// Constructor
	public Dao_Home() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Dao_Home(int seq, String file) {
		this.seq = seq;
		this.file = file;
	}

	
	// Method
	public List<Dto_Home> secondRow() {
		List<Dto_Home> dtoList = new ArrayList<Dto_Home>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select b.bid_status, p.title, b.start_price, u.nickname from bid b, post p, user u where b.userid = u.userid and b.postid = p.postid";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String bid_status = rs.getString(1);
				String p_title = rs.getString(2);
				int start_Price = rs.getInt(3);
				String u_nickname = rs.getString(4);
				
				Dto_Home dto = new Dto_Home(bid_status, p_title, start_Price, u_nickname);
				dtoList.add(dto);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// 작업 수정 해야함 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// 작업 수정 해야함 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// 작업 수정 해야함 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public List<Dto_Home> findAll() {
		List<Dto_Home> dtoList = new ArrayList<Dto_Home>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
//			String query = "select "
			
			dtoList.add(new Dto_Home(1, "구찌가방1.png"));
			dtoList.add(new Dto_Home(2, "구찌가방2.png"));
			dtoList.add(new Dto_Home(3, "구찌가방3.png"));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	// 작업 수정 해야함 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// 작업 수정 해야함 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// 작업 수정 해야함 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	
	public void getFileName() {
		
	}
	
	// 검색 결과를 Table로
//	public ArrayList<Dto_Home> userInfo() {
//		ArrayList<Dto_Home> dto = new ArrayList<Dto_Home>();
//		
//		String WhereDefault = "select imageid, from images ";
//		
//		Scanner sc = new Scanner(System.in);
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url_mysql, id_mysql,pw_mysql);
//			Statement st = con.createStatement();
//			
//			int num = sc.nextInt();
//			String query = "select post_image from image where imageid = " + num;
//			
//			ResultSet rs = st.executeQuery(query);
//			
//			rs.getString(1);
//			
//			//file
//			Share.filename = Share.filename + 1;
//			File file = new File(Integer.toString(Share.filename));
//			FileOutputStream output = new FileOutputStream(file);
//			InputStream input = rs.getBinaryStream(4);
//			byte[] buffer = new byte[1024];
//			while (input.read(buffer) > 0) {
//				output.write(buffer);
//			}
//			
//			con.close();
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	

}
