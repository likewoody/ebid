package com.javalec.function;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class Dao_Write {
	
	//Field
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	private String userid;
	private String pw;
	private String title;
	private String description;
	private String post_status;
	private String sort;
	private String price;
	private String view_count;
	private String start_date;
	private int postid;
	
	// 추가
	private String nickname;
	private String profile_image;
	private String sellerImage;
		
	

	//Constructor
	
	public Dao_Write() {
		
	}
	
	
	
	// 추가
	
	public Dao_Write(String userid, int postid, String nickname, String profile_image) {
		super();
		this.userid = userid;
		this.postid = postid;
		this.nickname = nickname;
		this.profile_image = profile_image;
	}





	public Dao_Write(String title, String description, String post_status, String sort, String price, String view_count,
			String start_date) {
		super();
		this.title = title;
		this.description = description;
		this.post_status = post_status;
		this.sort = sort;
		this.price = price;
		this.view_count = view_count;
		this.start_date = start_date;
	}
	
	


	public Dao_Write(String title, String description, String price) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
	}


	public Dao_Write(String userid) {
		super();
		this.userid = userid;
	}


	public Dto_Write userIdinput() {
		
		Dto_Write dto = null;
		
		String where1 = "select userid, pw from user where userid = '"+ Share.id +"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where1);
			
			while(rs.next()) {
				String userid = rs.getString(1);
						
				dto = new Dto_Write(userid);	
		}
		      
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // 어디서 오류가 났는지 출력
		}

		return dto;
		
    }
	 //회원 정보 업데이트
	
	public void wUpdate() {
	    // ...

	    //글게시 완료 업로드 *****************************************
	    String AA = "INSERT INTO ebid.post (title, description, post_status, sort, price, view_count, start_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        // ...
	        PreparedStatement pstmt = conn.prepareStatement(AA);

	        // Set other parameters
	        pstmt.setString(1, title);

	        // Handle newline characters in description
	        String formattedDescription = description.replace("\n", "<br>"); // Replace newline with HTML <br> tag
	        pstmt.setString(2, formattedDescription);

	        pstmt.setString(3, "판매중");
	        pstmt.setString(4, "판매");
	        pstmt.setString(5, price);
	        pstmt.setString(6, "0");

	        // 현재의 timestamp 얻기
	        java.sql.Timestamp start_date = new java.sql.Timestamp(System.currentTimeMillis());
	        pstmt.setTimestamp(7, start_date);

	        // 업데이트 실행
	        pstmt.executeUpdate();

	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    sUpdate();
	}

   
	//*******************추가 코드 nickname*******************
	// 이미지 파일을 바이트 배열로 읽어오는 메서드
	private byte[] readImageFile(String imagePath) throws IOException {
	
	    Path path = Paths.get(imagePath);
	    return Files.readAllBytes(path);
	}
	 	
	// ebid.User 테이블에서 userid를 기반으로 nickname과 profile_image를 가져오는 메서드
	public Dto_Write getUserInfo(Connection connection, String userid) throws SQLException,IOException {
        Dto_Write dto = new Dto_Write();
	
        String getUserInfoQuery = "SELECT nickname, profile_image FROM ebid.User WHERE userid = ?";
        try (PreparedStatement ps = connection.prepareStatement(getUserInfoQuery)) {
            ps.setString(1, userid);

            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    dto.setNickname(resultSet.getString("nickname"));         
                 
           
                    // profile_image를 가져와서 바이트 배열로 저장
                    byte[] profileImageBytes = resultSet.getBytes("profile_image");
                    dto.setSellerImage(Base64.getEncoder().encodeToString(profileImageBytes)); 
                    
                }
            }
        } 
        
        return dto;
	}
	
	 public void sUpdate() {
		 
		 //**********새로운 코드************************
 		 //-----sales table에 data 넣기----------
		    // sell로 변경

		    String postidQ = "SELECT MAX(postid) FROM ebid.post";
		    String userid = Share.id;
		    
		    String ISC ="INSERT INTO ebid.sell (userid, postid, nickname, sellerImage) VALUES (?, ?, ?, ?)";
		  
		   
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

		        // Step 1: Get the maximum postid from the database
		        int maxPostId = getMaxPostId(conn, postidQ);
		        
		        // Dao_Writing를 사용하여 사용자 정보 가져오기
		      //  Dao_Write daoWriting = new Dao_Write();
	            Dto_Write dtoWrite = getUserInfo(conn, userid);

		        // Step 2: Insert sales data using the obtained maxPostId
		        insertSalesData(conn, ISC, userid, maxPostId, dtoWrite.getNickname(), dtoWrite.getSellerImage());
		        

		        conn.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	 	
		private int getMaxPostId(Connection connection, String postidQ) throws SQLException {
		    try (PreparedStatement ps = connection.prepareStatement(postidQ);
		         ResultSet resultSet = ps.executeQuery()) {
		        if (resultSet.next()) {
		            return resultSet.getInt(1);
		        } else {
		            throw new SQLException("Error retrieving max postid");
		        }
		    }
		}
		
		// 추가: sellerImage로 수정
		private void insertSalesData(Connection connection, String insertSalesQuery, String userid, int postid, String nickname, String sellerImage) throws SQLException {
		    try (PreparedStatement pstmt = connection.prepareStatement(insertSalesQuery)) {
		        // Set the values for the insert statement
		        // 변경
		        pstmt.setString(1, userid);
		        pstmt.setInt(2, postid);
		        pstmt.setString(3, nickname);
		        
		        // sellerImage를 그대로 사용
		        pstmt.setString(4, sellerImage);
		        
		        // Base64로 인코딩된 이미지를 디코딩하여 바이트 배열로 변환
		       // byte[] sellerImageBytes = Base64.getDecoder().decode(sellerImage);
		        // 바이트 배열을 이용하여 Blob 객체 생성
		     //   Blob sellerImageBlob = connection.createBlob();
		      //  sellerImageBlob.setBytes(1, sellerImageBytes);
		      //  pstmt.setBlob(4, sellerImageBlob);

		       // Debugging: Add these print statements
		        System.out.println("userid: " + userid);
		        System.out.println("postid: " + postid);
		        System.out.println("nickname: " + nickname);
		        System.out.println("sellerImage: " + sellerImage);

		        // Execute the insert statement
		        int rowsAffected = pstmt.executeUpdate();
		        // System.out.println(rowsAffected + " row(s) inserted into ebid.sales successfully");
		    }
		}
		 
 	}
	 
	 
	 //-------사용잘됨---------------------------------
	 
	 
		    //-----sales table에 data 넣기----------
		 	// sell로 변경
		   /* 
		    String postidQ = "SELECT MAX(postid) FROM ebid.post";
		    String userid = Share.id;
		    String ISC ="INSERT INTO ebid.sell (userid, postid, nickname, sellerImage) VALUES (?, ?, ?, ?)"; //<=sell로 변경. 쿼리변경.
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        
		        // Step 1: Get the maximum postid from the database
		        int maxPostId =getMaxPostId(conn, postidQ);
		        
		        // Step 2: Insert sales data using the obtained maxPostId
		        insertSalesData(conn, ISC, userid, maxPostId, nickname, sellerImage);
		        
		        conn.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		 private int getMaxPostId(Connection connection, String postidQ) throws SQLException {
			    try (PreparedStatement ps = connection.prepareStatement(postidQ);
			         ResultSet resultSet = ps.executeQuery()) {
			        if (resultSet.next()) {
			            return resultSet.getInt(1);
			        } else {
			            throw new SQLException("Error retrieving max postid");
			        }
			    }
			}
		 
		 private void insertSalesData(Connection connection, String insertSalesQuery, String userid, int postid, String nickname, String sellerImage) throws SQLException {
			    try (PreparedStatement pstmt = connection.prepareStatement(insertSalesQuery)) {
			        // Set the values for the insert statement
			    	// 변경
			        pstmt.setString(1, userid);
			        pstmt.setInt(2, postid);
			        pstmt.setString(3, nickname);
			        pstmt.setString(4, sellerImage);

			        // Set the current timestamp
			     //   java.sql.Timestamp currentDateAndTime = new java.sql.Timestamp(System.currentTimeMillis());
			     //   pstmt.setTimestamp(3, currentDateAndTime);
			        
			        // Debugging: Add these print statements
			        System.out.println("userid: " + userid);
			        System.out.println("postid: " + postid);
			        System.out.println("nickname: " + nickname);
			        System.out.println("sellerImage: " + sellerImage);

			        // Execute the insert statement
			        int rowsAffected = pstmt.executeUpdate();
			       // System.out.println(rowsAffected + " row(s) inserted into ebid.sales successfully");
			    }
			}
		 
		 
	}// end
	 */


