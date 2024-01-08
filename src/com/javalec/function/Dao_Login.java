package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao_Login {

	
	//Field 
	
	
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	
	
	
	 private String userid;
     private String pw;
     private String phone;
     private String email;
     private String nickname;
     private String join_date;
     private String delete_date;
     private String profile_image;
     private String address;
     private String name;
	
	//Constructor
	
	public Dao_Login() {
		// TODO Auto-generated constructor stub
	}

	public Dao_Login(String userid, String pw, String phone, String email, String nickname, String join_date,
			String delete_date, String profile_image, String address, String name) {
		super();
		this.userid = userid;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.nickname = nickname;
		this.join_date = join_date;
		this.delete_date = delete_date;
		this.profile_image = profile_image;
		this.address = address;
		this.name = name;
		
	}
	
	
	
	
	
	
	
	//Method
	
	//	로그인 실행
				
	
	public boolean LoginAction() {
	     boolean yesLogin = false;
		String A = "select pw from user where userid + '"+ userid + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(A);
			
			
				if (rs.next()) {
					if (rs.getString(1).equals(pw)) {
								yesLogin = true;
				conn.close();
				}
			}
		}
		catch (Exception e) {
			yesLogin = false;
		}
		return yesLogin;
		
	}
		
	//id 중복체크
	public boolean Idcheck() {
		boolean passableId = false;
		String B ="select userid from user";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(B);
		
				if ( rs.next()) {
						passableId = false;
				}
				conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			
	
		return passableId;
	
	}
		
	//id 찾기
	public boolean findId() {
			boolean searchId = false;
			String C = "select userid from user where userid = '" + userid + "' and phone = '" + phone + "'";
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(C);
				
				 if( rs.next()) {
					 	searchId = true;
				 }else { 
					 searchId = false;
				 }
			conn.close();
			
	}
	catch( Exception e) {
		e.printStackTrace();
	}
	return searchId;
	}
	
	//pw 찾기
	
	public boolean findPw() {
		boolean searchPw = false;
		String D = "SELECT pw FROM user WHERE userid = ? AND name = ? AND phone = ?";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(D);
			
		if ( rs.next()) {
				searchPw = true;
		}else {
				searchPw = false;
		}
		conn.close();
		
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	return searchPw;
	}
}
