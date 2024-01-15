package com.javalec.function;

import java.awt.Image;
import java.io.ByteArrayInputStream;
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
	String post_status;
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
	
	// Create
	
	public void createChatRoom() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String query = "insert into chat (userid, nickname, date, sellid, userImage) values (?, ?, now(), ?, ?)";
			
			ps = con.prepareStatement(query);
			
//			System.out.println(Share.id + ": inside create chatroom id");
//			System.out.println(findUserNickname() + " : user nick");
//			System.out.println(findSellerId() + " : seller id");
//			System.out.println(Share.sellId + " : sellid");
			ps.setString(1, Share.id);
			ps.setString(2, findUserNickname());
//			ps.setString(3, findSellerId());
			ps.setInt(3, Share.sellId);
			
			ByteArrayInputStream inputStream = new ByteArrayInputStream(findBuyerImage());
			ps.setBlob(4, inputStream);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Read
	public ArrayList<Dto_Home> searchDB() {
		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>();
		Dto_Home dto = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "SELECT max_image.post_image, p.title, p.price, u.nickname, p.post_status, p.postid, max_image.sellid, "
					+ "					  ( "
					+ "					       SELECT COUNT(w.postid) "
					+ "					    FROM wish_list w "
					+ "					      WHERE w.postid = p.postid "
					+ "					  ) AS wish_list_count, "
					+ "					  ( "
					+ "					       SELECT COUNT(c.sellid) "
					+ "				        FROM chat c "
					+ "				        JOIN sell s ON c.sellid = s.sellid "
					+ "					      JOIN post p ON s.postid = p.postid "
					+ "					       WHERE p.postid = max_image.postid "
					+ "					   ) AS chat_count "
					+ "				FROM ( "
					+ "				   SELECT MAX(i.post_image) AS post_image, p.postid, p.start_date, s.sellid "
					+ "					   FROM image i "
					+ "					    JOIN post p ON p.postid = i.postid "
					+ "					    LEFT JOIN sell s ON s.postid = p.postid "
					+ "					    GROUP BY p.postid, s.sellid "
					+ "					) max_image "
					+ "					LEFT JOIN post p ON max_image.postid = p.postid "
					+ "					LEFT JOIN user u ON u.userid = ( "
					+ "					   SELECT s.userid "
					+ "					   FROM sell s "
					+ "					    WHERE s.postid = p.postid) "
					+ "					order by p.start_date desc;";
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				
				dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6), 
						rs.getInt(7), rs.getInt(8), rs.getInt(9));
				
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
		String A = "SELECT max_image.post_image, p.title, p.price, u.nickname, p.post_status, p.postid, max_image.sellid, "
				+ "					  ( "
				+ "					       SELECT COUNT(w.postid) "
				+ "					    FROM wish_list w "
				+ "					      WHERE w.postid = p.postid "
				+ "					  ) AS wish_list_count, "
				+ "					  ( "
				+ "					       SELECT COUNT(c.sellid) "
				+ "				        FROM chat c "
				+ "				        JOIN sell s ON c.sellid = s.sellid "
				+ "					      JOIN post p ON s.postid = p.postid "
				+ "					       WHERE p.postid = max_image.postid "
				+ "					   ) AS chat_count "
				+ "				FROM ( "
				+ "				   SELECT MAX(i.post_image) AS post_image, p.postid, p.start_date, s.sellid "
				+ "					   FROM image i "
				+ "					    JOIN post p ON p.postid = i.postid "
				+ "					    LEFT JOIN sell s ON s.postid = p.postid "
				+ "					    GROUP BY p.postid, s.sellid "
				+ "					) max_image "
				+ "					LEFT JOIN post p ON max_image.postid = p.postid "
				+ "					LEFT JOIN user u ON u.userid = ( "
				+ "					   SELECT s.userid "
				+ "					   FROM sell s "
				+ "					    WHERE s.postid = p.postid) "
				+ "where p.title like '%" + searchText + "%' "
						+ "order by p.start_date desc";
		
		// 닉네임으로 검색
		String B = "SELECT max_image.post_image, p.title, p.price, u.nickname, p.post_status, p.postid, max_image.sellid, "
				+ "					  ( "
				+ "					       SELECT COUNT(w.postid) "
				+ "					    FROM wish_list w "
				+ "					      WHERE w.postid = p.postid "
				+ "					  ) AS wish_list_count, "
				+ "					  ( "
				+ "					       SELECT COUNT(c.sellid) "
				+ "				        FROM chat c "
				+ "				        JOIN sell s ON c.sellid = s.sellid "
				+ "					      JOIN post p ON s.postid = p.postid "
				+ "					       WHERE p.postid = max_image.postid "
				+ "					   ) AS chat_count "
				+ "				FROM ( "
				+ "				   SELECT MAX(i.post_image) AS post_image, p.postid, p.start_date, s.sellid "
				+ "					   FROM image i "
				+ "					    JOIN post p ON p.postid = i.postid "
				+ "					    LEFT JOIN sell s ON s.postid = p.postid "
				+ "					    GROUP BY p.postid, s.sellid "
				+ "					) max_image "
				+ "					LEFT JOIN post p ON max_image.postid = p.postid "
				+ "					LEFT JOIN user u ON u.userid = ( "
				+ "					   SELECT s.userid "
				+ "					   FROM sell s "
				+ "					    WHERE s.postid = p.postid) "
				+ "where u.nickname like '%" + searchText + "%' "
						+ "order by p.start_date desc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();

			
			// 제목으로 입력시 
			if (index == 0) {
				ResultSet rs = st.executeQuery(A);

				while (rs.next()) {

					dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), 
							rs.getString(4), rs.getString(5), rs.getInt(6), 
							rs.getInt(7), rs.getInt(8), rs.getInt(9));
					dtoList.add(dto);
				}
			}

			// 닉네임으로 입력시 
			if (index == 1) {
				ResultSet rs = st.executeQuery(B); 

				while (rs.next()) {

					dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), 
							rs.getString(4), rs.getString(5), rs.getInt(6), 
							rs.getInt(7), rs.getInt(8), rs.getInt(9));
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
	
	
	// 데이터가 없다면 wish_list에 입력
	public void insertWish() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String query = "INSERT INTO wish_list (userid, postid, wish_status) VALUES (?, ?, ?)";

			ps = con.prepareStatement(query);
			ps.setString(1, Share.id);
			ps.setInt(2, Share.postId);
			ps.setInt(3, 1);
			
			ps.executeUpdate();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 데이터가 있다면 update를 통해 데이터 수정
	public void updateWishStatus() {
		
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String query = "update wish_list set wish_status = "
					+ "					case "
					+ "					when wish_status = 0 then 1 "
					+ "					when wish_status = 1 then 0 end "
					+ "					where userid = '" + Share.id + "' and postid = " + Share.postId;
			
			ps = con.prepareStatement(query);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 클릭한 wish_list의 status를 불러온다.
	public int findWishStatus() {
		int Flag = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select w.wish_status from wish_list w, user u where w.userid = u.userid and w.userid = '" + Share.id + "' and w.postid = " + Share.postId;
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				Flag = rs.getInt(1);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Flag;
	}
	
	// 유저의 image를 가져온다
	public byte[] findSellerImage() {
		byte[] sellerImage = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select profile_image from user u, sell s "
					+ "where s.userid = u.userid "
					+ "and s.sellid = " + Share.sellId;
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				sellerImage = rs.getBytes(1);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sellerImage;
	}
	
	public byte[] findBuyerImage() {
		byte[] buyerImage = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select profile_image from user u "
					+ "where u.userid = '"+Share.id+"'";
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				buyerImage = rs.getBytes(1);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return buyerImage;
	}
	
	// find user rating
	public String findUserRating() {
		String str = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			String query = "SELECT ROUND(AVG(r.rating), 1) "
					+ "FROM rating r "
					+ "JOIN user u ON r.userid = u.userid "
					+ "JOIN sell s ON s.userid = u.userid "
					+ "WHERE s.sellid = '" + Share.sellId + "'";
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				str = String.format("%.1f", rs.getDouble(1));
//				str = Double.toString();
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
	
	// find 판매중인지 혹은 판매완료인지 체크
	public String findPostStatus() {
		String str = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select post_status from post "
					+ "where postid = " + Share.postId;
			
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
	
	// set static sell id 
	public List<Dto_Home> findSellId() {
		List<Dto_Home> dtoL = new ArrayList<Dto_Home>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select sellid from sell where postid = " + Share.postId;
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				Dto_Home dto = new Dto_Home(rs.getInt(1));
				dtoL.add(dto);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoL;
	}
	
	private String findUserNickname() {
		String userNickname = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select nickname from user where userid = '" + Share.id + "'";
			
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				userNickname = rs.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return userNickname;
	}
	
	public int findChatId() {
		int newChatId = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select chatid from chat where userid = '" + Share.id + "' and sellid = " + Share.sellId;
			
			ResultSet rs = st.executeQuery(query);
		
			if(rs.next()) {
				newChatId = rs.getInt(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return newChatId;
	}
	
	//
	public String findSellerId() {
		String sellerId = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select userid from sell where postid = " + Share.postId;
			
			ResultSet rs = st.executeQuery(query);
		
			if(rs.next()) {
				sellerId = rs.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sellerId;
	} 
	
	// find if chat already exist
	public boolean findChatExist() {
		boolean checkExist = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select * from chat where userid = '" + Share.id + "' and sellid = " + Share.sellId;
			
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				checkExist = true;
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return checkExist;
	}
	
	// check if user is blocked or not
	public boolean checkBlock() {
		boolean checkBlockorNot = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select distinct (select userid from sell where sellid = 14) sellerid, block_user from block_list where block_user = '" + Share.id + "'";
			
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				checkBlockorNot = true;
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return checkBlockorNot;
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