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

import com.mysql.cj.jdbc.Blob;


public class Dao_Home {
	
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	int imageid;
	int postid;
	byte[] post_image;
	String post_title; // 포스트 제목
	int start_price;
	String nickname;
	ImageIcon imageIcon;
	
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
			
			String query = "SELECT"
					+ "    max_image.post_image, "
					+ "    p.title, "
					+ "    p.price, "
					+ "    u.nickname, "
					+ "	p.sort "
					+ "FROM "
					+ "    ( "
					+ "        SELECT "
					+ "            MAX(i.post_image) AS post_image, "
					+ "            p.postid "
					+ "        FROM "
					+ "            image i "
					+ "        JOIN post p ON p.postid = i.postid "
					+ "        LEFT JOIN bid b ON b.postid = p.postid "
					+ "        LEFT JOIN sell s ON s.postid = p.postid "
					+ "        GROUP BY "
					+ "            p.postid "
					+ "    ) max_image "
					+ "JOIN post p ON max_image.postid = p.postid "
					+ "JOIN user u ON u.userid = ( "
					+ "    SELECT "
					+ "        CASE "
					+ "            WHEN MAX(b.userid) IS NOT NULL THEN MAX(b.userid) "
					+ "            WHEN MAX(s.userid) IS NOT NULL THEN MAX(s.userid) "
					+ "        END "
					+ "    FROM "
					+ "        bid b "
					+ "    LEFT JOIN sell s ON s.postid = p.postid "
					+ "    WHERE "
					+ "        b.postid = p.postid OR s.postid = p.postid "
					+ ")"
					+ "ORDER BY "
					+ "    p.update_date DESC";
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				
				if (rs.getString(5).equals("판매")) {
					dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				}
				
				if (rs.getString(5).equals("경매")) {
					dto = new Dto_Home(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				}
				
				dtoList.add(dto);
				
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
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
//	}
	
}
