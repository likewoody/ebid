package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
     private int delete_date;
     private String profile_image;
     private String address;
     private String name;
	
	//Constructor
	
	public Dao_Login() {
		// TODO Auto-generated constructor stub
	}

	public Dao_Login(String userid, String pw, String phone, String email, String nickname, String join_date,
			int delete_date, String profile_image, String address, String name) {
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
	
	 public Dao_Login(String userid, String pw) {
	        this.userid = userid;
	        this.pw = pw;
	    }
	
	
	
	    public void setNickname(String nickname) {
	        this.nickname = nickname;
	    }

	 
	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	


	public Dao_Login(String userid) {
		super();
		this.userid = userid;
	}
	public String getPw() {
        return pw;
    }
	//Method
	
	//	로그인 실행
				
	
	public boolean LoginAction() {
	     boolean yesLogin = false;
		String A = "SELECT pw FROM user WHERE userid = '" + userid + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(A);
			
						
			 if (rs.next()) {
		            String storedPw = rs.getString("pw"); // pw 컬럼의 값을 가져옴
		            if (storedPw.equals(pw)) {
		                yesLogin = true;
		            }
						

				}
					
			conn.close();
				
			
		}
		catch (Exception e) {
		    e.printStackTrace();

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
			String C = "SELECT userid FROM user WHERE nickname = ? AND phone = ?";
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//				Statement st = conn.createStatement();
//				ResultSet rs = st.executeQuery(C);
				 PreparedStatement pstmt = conn.prepareStatement(C);
				 pstmt.setString(1, this.nickname);
		         pstmt.setString(2, this.phone);
		            
		         ResultSet rs = pstmt.executeQuery();
//		            
//				 if( rs.next()) {
//					 	searchId = true;
//				 }else { 
//					 searchId = false;
//				 }
//			conn.close();
//			
//	}
//	catch( Exception e) {
//		e.printStackTrace();
//	}
//	return searchId;
//	}
		         if (rs.next()) {
		                searchId = true;
		                userid = rs.getString("userid");
		            }

		            conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return searchId;
		    }

		    public String getUserid() {
		        return userid;
		    }
	

	//pw 찾기
	
	public boolean findPw() {
		boolean searchPw = false;
		String D = "SELECT pw FROM user WHERE userid = ? AND nickname = ? AND phone = ?";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//		Statement st = conn.createStatement();
//		RPreparedStatement pstmt = conn.prepareStatement(D);
		 PreparedStatement pstmt = conn.prepareStatement(D);
        pstmt.setString(1, this.userid);
        pstmt.setString(2, this.nickname);
        pstmt.setString(3, this.phone);

        ResultSet rs = pstmt.executeQuery();
//        		esultSet rs = st.executeQuery(D);
			
		if ( rs.next()) {
				searchPw = true;
				 pw = rs.getString("pw");
		
		}
		conn.close();
		
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	return searchPw;
	}
}
