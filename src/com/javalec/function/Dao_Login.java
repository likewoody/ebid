package com.javalec.function;	

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.javalec.base.Register;
import com.mysql.cj.exceptions.RSAException;

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
     public boolean passableNickname = true;
    // public boolean deleteCom = true;
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
	
	 public Dao_Login(String userid, String pw, String phone, String nickname, String address) {
		super();
		this.userid = userid;
		this.pw = pw;
		this.phone = phone;
		this.nickname = nickname;
		this.address = address;
	}
	 
	 public Dao_Login(String pw, String phone, String nickname) {
		 super();
		 this.pw = pw;
		 this.phone = phone;
		 this.nickname = nickname;
	 }

	public Dao_Login(String userid, String pw) {
	        this.userid = userid;
	        this.pw = pw;
	    }
	

	public Dao_Login(boolean passableNickname) {
			super();
			this.passableNickname = passableNickname;
		}

	public Dao_Login(String userid) {
		super();
		this.userid = userid;
	}
				
	
	//id , pw 를 찾기위한 메소드
	  public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public void setNickname(String nickname) {
	        this.nickname = nickname;
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
		boolean passableId = true;
		String B ="select userid from user where userid = ?";				
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			PreparedStatement pstmt = conn.prepareStatement(B);

						
			
					
			  											// 사용자 ID를 설정
			pstmt.setString(1, this.userid);
					
			ResultSet rs = pstmt.executeQuery();			
					
				if ( rs.next()) {
						passableId = false;					        
				
					//	System.out.println("Duplicate ID found: " + this.userid);
				}else { 
									
							
			    // 아이디가 중복되지 않으면 데이터베이스에 등록
				 //   System.out.println("ID not found. Registering: " + this.userid);
			if ( this.userid != null) {   
	            String insertQuery = "INSERT INTO user (userid) VALUES (?)";
	            PreparedStatement insertPstmt = conn.prepareStatement(insertQuery);
	            insertPstmt.setString(1, this.userid);
	            insertPstmt.executeUpdate();
			}else {
//				 System.out.println("Error: this.userid is null");
			}
				}
	        
				conn.close();
				}
				catch( SQLIntegrityConstraintViolationException e) {
					e.printStackTrace();
				    passableId = false;
				}catch ( Exception e) {
					e.printStackTrace();
					passableId = true;
				}
							
	
		return passableId;
								
}
			//회원가입 취소시 아이디 삭제
	public void idDelete() {
		String X = "delete from user where userid = ?";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			PreparedStatement D = conn.prepareStatement(X);
		
			
					D.setString(1, this.userid);
					D.executeUpdate();
					conn.close();
					 
					
		}catch (Exception e) {
			e.printStackTrace();
			 
		}
		
	}
	
		
		
	public boolean nickNameCheck(String nickname) {
	//	public boolean nickNameCheck() {
		boolean boolCheck = true;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = conn.createStatement();
			String query = "select nickname from user where nickname = '" + nickname + "'";
			ResultSet rs = st.executeQuery(query);
			// 사용자 nickname 설정
			if (rs.next()) {
				String strCheck = rs.getString(1);
				if (strCheck.trim().equals(nickname.trim())) {
					boolCheck = false;
				}
			}
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			boolCheck = true;
		}
		return boolCheck;
	}
		
	//id 찾기
	public boolean findId() {
			boolean searchId = false;
			String C = "SELECT userid FROM user WHERE nickname = ? AND phone = ?";
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

				 PreparedStatement pstmt = conn.prepareStatement(C);
				 pstmt.setString(1, this.nickname);
		         pstmt.setString(2, this.phone);
		            
		         ResultSet rs = pstmt.executeQuery();

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
					
		 PreparedStatement pstmt = conn.prepareStatement(D);
        pstmt.setString(1, this.userid);
        pstmt.setString(2, this.nickname);
        pstmt.setString(3, this.phone);
        			
        ResultSet rs = pstmt.executeQuery();
        	
			
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

	public void signUpdate() {
		   // 회원 정보 업데이트 쿼리
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateAndTime = sdf.format(new Date());

		
	    String A = "UPDATE user SET pw = ?, phone = ?, nickname = ?, join_date = ?, address = ? WHERE userid = ?";
	   
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        
	        

	        
	        
	        
	        //업데이트
	        PreparedStatement pstmt = conn.prepareStatement(A);
	        pstmt.setString(1, pw);
	        pstmt.setString(2, phone);
	        pstmt.setString(3, nickname);
	        pstmt.setString(4, currentDateAndTime);
	        pstmt.setString(5, address);
	        pstmt.setString(6, userid);

	        // 업데이트 실행
	        pstmt.executeUpdate();

	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
	
	
	
	
	
	
	
}
