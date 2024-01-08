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
	
	// Constructor
	public Dao_Home() {
		// TODO Auto-generated constructor stub
	}
	
	// Method
	
	// get 2번째 컬럼 정보
	public ArrayList<Dto_Home> searchDB() {
		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>();
		Dto_Home dto = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "SELECT max_image.post_image, p.title, p.price, p.sort, u.nickname, p.postid "
					+ "from ( "
					+ "SELECT MAX(i.post_image) AS post_image, p.postid "
					+ "FROM image i "
					+ "JOIN post p ON p.postid = i.postid "
					+ "LEFT JOIN sell s ON s.postid = p.postid "
					+ "GROUP BY p.postid) max_image "
					+ "left join post p on max_image.postid = p.postid "
					+ "left join user u on u.userid = "
					+ "(select s.userid "
					+ "from sell s "
					+ "where s.postid = p.postid)";
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				
//				if (rs.getString(4).equals("판매")) {
				dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
//				}
				
//				if (rs.getString(4).equals("경매")) {
//					dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
//				}
				
				dtoList.add(dto);
				
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public ArrayList<Dto_Home> search(int index, String searchText) {
		ArrayList<Dto_Home> dtoList = new ArrayList<Dto_Home>(); // Dto_Product라는 타입을 가진 ArrayList 생성
		PreparedStatement ps = null;

		// SQL 구문
		String A = "SELECT max_image.post_image, p.title, p.price, p.sort, u.nickname "
				+ "from ( "
				+ "SELECT MAX(i.post_image) AS post_image, p.postid "
				+ "FROM image i "
				+ "JOIN post p ON p.postid = i.postid "
				+ "LEFT JOIN sell s ON s.postid = p.postid "
				+ "GROUP BY p.postid) max_image "
				+ "left join post p on max_image.postid = p.postid "
				+ "left join user u on u.userid = "
				+ "(select s.userid "
				+ "from sell s "
				+ "where s.postid = p.postid) "
				+ "where p.title like '" + searchText + "%'";
		
		String B = "SELECT max_image.post_image, p.title, p.price, p.sort, u.nickname "
				+ "from ( "
				+ "SELECT MAX(i.post_image) AS post_image, p.postid "
				+ "FROM image i "
				+ "JOIN post p ON p.postid = i.postid "
				+ "LEFT JOIN sell s ON s.postid = p.postid "
				+ "GROUP BY p.postid) max_image "
				+ "left join post p on max_image.postid = p.postid "
				+ "left join user u on u.userid = "
				+ "(select s.userid "
				+ "from sell s "
				+ "where s.postid = p.postid) "
				+ "where u.nickname like '" + searchText + "%'";
		
		String C = "select seq,name,price from product where name like " + searchText + "%' order by price desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();

			if (index == 0) {
				ResultSet rs = st.executeQuery(A); // asc구문 삽입

				while (rs.next()) {

					Dto_Home dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
					dtoList.add(dto);
				}
			}

			if (index == 1) {
				ResultSet rs = st.executeQuery(B); // asc구문 삽입

				while (rs.next()) {

					Dto_Home dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
					dtoList.add(dto);
				}
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace(); // 어디서 오류가 났는지 출력
		}

		return dtoList; // 불러온 데이터가 입력 된 dtoList 리턴
	}
	
	
	// 수정 필요 ********
	public int viewCount(int pId) {
		int count = 0;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select view_count from post p where postid = " + pId;
			
			ResultSet rs = st.executeQuery(query);
			
			count = rs.getInt(1);
			count ++;
			
			ps = con.prepareStatement("update post set view_count = ? where postid = " + pId);
			
			ps.setInt(1, count);
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
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
