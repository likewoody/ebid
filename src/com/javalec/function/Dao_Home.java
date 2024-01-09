package com.javalec.function;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Dao_Home {
	
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	int postId;
	byte[] post_image;
	String title; // 포스트 제목
	int start_price;
	String nickname;
	String sort;
	int max_price;
	int viewCount;
	String desc;
	
	// Constructor
	public Dao_Home() {
		// TODO Auto-generated constructor stub
	}
	
	public Dao_Home(int postId) {
		this.postId = postId;
	}
	
//	public Dao_Home(byte[] post_image, String title, String nickname, String desc, int start_price) {
//		this.post_image = post_image;
//		this.title = title;
//		this.nickname = nickname;
//		this.desc = desc;
//		this.start_price = start_price;
//	}
	
	
	// Method
	
	public ArrayList<Dto_Home> searchDB() {
		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>();
		Dto_Home dto = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "SELECT max_image.post_image, p.title, p.price, u.nickname, p.sort, p.postid, "
					+ "    ( "
					+ "        SELECT COUNT(DISTINCT w.postid) "
					+ "        FROM wish_list w "
					+ "        WHERE w.postid = p.postid "
					+ "    ) AS wish_list_count, "
					+ "    ( "
					+ "        SELECT COUNT(c.sellid) "
					+ "        FROM chat c "
					+ "        JOIN sell s ON c.sellid = s.sellid "
					+ "        JOIN post p ON s.postid = p.postid "
					+ "        WHERE p.postid = max_image.postid "
					+ "    ) AS chat_count "
					+ "FROM ( "
					+ "    SELECT MAX(i.post_image) AS post_image, p.postid "
					+ "    FROM image i "
					+ "    JOIN post p ON p.postid = i.postid "
					+ "    LEFT JOIN sell s ON s.postid = p.postid "
					+ "    GROUP BY p.postid "
					+ ") max_image "
					+ "LEFT JOIN post p ON max_image.postid = p.postid "
					+ "LEFT JOIN user u ON u.userid = ( "
					+ "    SELECT s.userid "
					+ "    FROM sell s "
					+ "    WHERE s.postid = p.postid);";
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				
				dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				
				dtoList.add(dto);
				
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	
	// 검색 시 필요한 method
	public ArrayList<Dto_Home> search(int index, String searchText) {
		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>(); // Dto_Product라는 타입을 가진 ArrayList 생성
		Dto_Home dto = null;
		
		// SQL 구문
		// 타이틀로 검색
		String A = "SELECT max_image.post_image, p.title, p.price, u.nickname, p.sort, p.postid, "
				+ "    ( "
				+ "        SELECT COUNT(DISTINCT w.postid) "
				+ "        FROM wish_list w "
				+ "        WHERE w.postid = p.postid "
				+ "    ) AS wish_list_count, "
				+ "    ( "
				+ "        SELECT COUNT(c.sellid) "
				+ "        FROM chat c "
				+ "        JOIN sell s ON c.sellid = s.sellid "
				+ "        JOIN post p ON s.postid = p.postid "
				+ "        WHERE p.postid = max_image.postid "
				+ "    ) AS chat_count "
				+ "FROM ( "
				+ "    SELECT MAX(i.post_image) AS post_image, p.postid "
				+ "    FROM image i "
				+ "    JOIN post p ON p.postid = i.postid "
				+ "    LEFT JOIN sell s ON s.postid = p.postid "
				+ "    GROUP BY p.postid "
				+ ") max_image "
				+ "LEFT JOIN post p ON max_image.postid = p.postid "
				+ "LEFT JOIN user u ON u.userid = ( "
				+ "    SELECT s.userid "
				+ "    FROM sell s "
				+ "    WHERE s.postid = p.postid) "
				+ "where p.title like '%" + searchText + "%'";
		
		// 닉네임으로 검색
		String B = "SELECT max_image.post_image, p.title, p.price, u.nickname, p.sort, p.postid, "
				+ "    ( "
				+ "        SELECT COUNT(DISTINCT w.postid) "
				+ "        FROM wish_list w "
				+ "        WHERE w.postid = p.postid "
				+ "    ) AS wish_list_count, "
				+ "    ( "
				+ "        SELECT COUNT(c.sellid) "
				+ "        FROM chat c "
				+ "        JOIN sell s ON c.sellid = s.sellid "
				+ "        JOIN post p ON s.postid = p.postid "
				+ "        WHERE p.postid = max_image.postid "
				+ "    ) AS chat_count "
				+ "FROM ( "
				+ "    SELECT MAX(i.post_image) AS post_image, p.postid "
				+ "    FROM image i "
				+ "    JOIN post p ON p.postid = i.postid "
				+ "    LEFT JOIN sell s ON s.postid = p.postid "
				+ "    GROUP BY p.postid "
				+ ") max_image "
				+ "LEFT JOIN post p ON max_image.postid = p.postid "
				+ "LEFT JOIN user u ON u.userid = ( "
				+ "    SELECT s.userid "
				+ "    FROM sell s "
				+ "    WHERE s.postid = p.postid) "
				+ "where u.nickname like '%" + searchText + "%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();

			
			// 제목으로 입력시 
			if (index == 0) {
				ResultSet rs = st.executeQuery(A);

				while (rs.next()) {

					dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
					dtoList.add(dto);
				}
			}

			// 닉네임으로 입력시 
			if (index == 1) {
				ResultSet rs = st.executeQuery(B); 

				while (rs.next()) {

					dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
					dtoList.add(dto);
				}
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace(); // 어디서 오류가 났는지 출력
		}

		return dtoList; // 불러온 데이터가 입력 된 dtoList 리턴
	}
	// serach image for detail class
	public ArrayList<Dto_Home> findPostImage() {
		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select post_image from image where postid = " + Share.postId;
			
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Dto_Home dto = new Dto_Home(rs.getBytes(1));
				dtoList.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// find user datas title, nickname, post description, price
	public ArrayList<Dto_Home> findUserInfo() {
		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			String query = "SELECT p.title, u.nickname, p.description, p.price "
					+ "FROM user u "
					+ "join sell s on u.userid = s.userid "
					+ "join post p on s.postid = p.postid "
					+ "where s.sellid = " + Share.sellId;
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
//				byte[] profileImage = rs.getBytes(1);
				String postTitle = rs.getString(1);
				String userNickname = rs.getString(2);
				String postDesc = rs.getString(3);
				int postPrice = rs.getInt(4);
				
				Dto_Home dto = new Dto_Home(postTitle, userNickname, postDesc, postPrice);
				
				dtoList.add(dto);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// 유저의 image를 가져온다
	public byte[] findUserImage() {
		byte[] userImage = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select profile_image from user u, sell s "
					+ "where s.userid = u.userid "
					+ "and s.sellid = " + Share.sellId;
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				userImage = rs.getBytes(1);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return userImage;
	}
	
	
	// find user rating
	public String findUserRating() {
		String str = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select avg(rating) "
					+ "from rating r, user u, sell s "
					+ "where r.userid = u.userid "
					+ "and s.userid= u.userid "
					+ "and s.sellid = " + Share.sellId;
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				str = Double.toString(rs.getDouble(1));
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	// find post title for detail class
	public String findPostTitle() {
		String str = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select p.title from post p where p.postid = " + Share.postId;
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				str = rs.getString(1);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	// detail로 들어온 제품을 위시리스트로 찜을 했는지 체크
	public boolean findWishList() {
		boolean boolFlag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select wish_status from wish_list w, user u, post p "
					+ "where p.postid = " + Share.postId
					+ " and u.userid = '" + Share.id + "'";
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.getInt(1) == 1) {
				boolFlag = true;
			}
			else boolFlag = false;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return boolFlag;
	}
	

	// 고객이 클릭 시 제품 카운트를 센다
	public void viewCount() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String queryInsert = "update post "
					+ "set view_count = view_count + 1 "
					+ "where postid = " + postId;
			
			ps = con.prepareStatement(queryInsert);
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	private int findSellId(int sellId) {
//		int findId = 0;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement st = con.createStatement();
//			
//			String query = "select count(*) from chat c, sell s where c.sellid = s.sellid and s.sellid = " + sellId;
//			
//			ResultSet rs = st.executeQuery(query);
//			
//			if(rs.next()) {
//				findId = rs.getInt(1);
//			}
//			
//			con.close();
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return findId;
//	}
//	public void viewCountInsert(int pId) {
//		PreparedStatement ps = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			ps = con.prepareStatement("update post set view_count = ? where postid = " + pId);
//			
//			ps.setInt(1, viewCount);
//			ps.executeUpdate();
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	// looking for image
//	public ArrayList<Dto_Home> getImage() {
//		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>();
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement st = con.createStatement();
//			
//			String query = "SELECT MAX(i.post_image) AS post_image "
//					+ "FROM image i, user u, post p, bid b, sell s "
//					+ "WHERE (b.userid = u.userid AND b.postid = p.postid AND p.postid = i.postid) "
//					+ "   OR (s.userid = u.userid AND s.postid = p.postid AND i.postid = p.postid) "
//					+ "GROUP BY p.postid "
//					+ "order by p.update_date desc";
//			
//			ResultSet rs = st.executeQuery(query);
//			
//			while(rs.next()) {
//				
//				Dto_Home dto = new Dto_Home(rs.getBytes(1));
//				dtoList.add(dto);
//			}
//			
//			con.close();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dtoList;
//		}	
	
	
}