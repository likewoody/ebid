package com.javalec.function;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

public class Dao_Chat {
	
	
	// field
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	private int rating;
	
	// constructor
	public Dao_Chat() {
		// TODO Auto-generated constructor stub
	}
	
	public Dao_Chat(int rating) {
		this.rating = rating;
	}



	// method
	
	// insert
	public void insertChat(String chatText) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into chat_text_detail (chatid, text, date, userid) "
					+ "values(?, ?, now(), ?)";
			
			ps = con.prepareStatement(query);
//			System.out.println(Share.chatid + "adsasdasdasdasdasd chatid");
//			System.out.println(Share.id);
			System.out.println(Share.chatid + " : insdie insert chat");
			ps.setInt(1, Share.chatid);
			ps.setString(2, chatText);
			ps.setString(3, Share.id);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertImage(byte[] image) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into chat_text_detail (chatid, image, date, userid) "
					+ "values(?, ?, now(), ?)";
			
			ps = con.prepareStatement(query);
//			System.out.println(Share.chatid + "adsasdasdasdasdasd chatid");
//			System.out.println(Share.id);
			ps.setInt(1, Share.chatid);
			
			// Create a ByteArrayInputStream from the byte array
			// byte타입을 input하기 위함
			ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
            
			ps.setBlob(2, inputStream);
			ps.setString(3, Share.id);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void block() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into block_list (userid, block_user) "
					+ "values(?, ?)";
			
			ps = con.prepareStatement(query);
//			System.out.println(Share.chatid + "adsasdasdasdasdasd chatid");
//			System.out.println(Share.id);
			ps.setString(1, Share.id);
			ps.setString(2, Share.checkUser);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertRating() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into rating (userid, rating, date) "
					+ "values(?, ?, now())";
			
			ps = con.prepareStatement(query);
			ps.setString(1, Share.id);
			ps.setInt(2, rating);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// read
	public ArrayList<Dto_Chat> searchChat() {
		ArrayList<Dto_Chat> dtoList = new ArrayList<Dto_Chat>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement st = con.createStatement();
			
			String query = "SELECT s.sellerImage, s.nickname, c.title, date_format(c.date, '%y.%m.%d %H:%i'), c.chatid "
					+ "					from chat c, sell s "
					+ "					where c.sellid = s.sellid "
					+ "                    and c.userid = '" + Share.id+ "' "
					+ "					order by c.date desc;" ;
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				byte[] profile_img = rs.getBytes(1);
				String nick = rs.getString(2);
				String post_title = rs.getString(3);
				String chatDate = rs.getString(4);
				int chatId = rs.getInt(5);
//				String userId = rs.getString(6);
//				String sellUserId = rs.getString(7);
//				int date = rs.getInt(6);
				
				Dto_Chat dto = new Dto_Chat(profile_img, nick, post_title, chatDate, chatId);
				dtoList.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// 채팅방 안에 들어갔을 때 채팅 상황
	public ArrayList<Dto_Chat> findChatDeatil() {
	    ArrayList<Dto_Chat> dtoList = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

	        String textQuery = "SELECT "
	        		+ "    c.userImage, "
	        		+ "    cd.text,  "
	        		+ "    DATE_FORMAT(cd.date, '%y.%m.%d %H:%i') as formatted_date, "
	        		+ "    u.nickname "
	        		+ "FROM "
	        		+ "    chat c "
	        		+ "JOIN "
	        		+ "    sell s ON s.sellid = c.sellid "
	        		+ "JOIN "
	        		+ "    chat_text_detail cd ON cd.chatid = c.chatid "
	        		+ "JOIN "
	        		+ "    user u ON u.userid = cd.userid "
	        		+ "WHERE "
	        		+ "    c.chatid = " + Share.chatid;

	        try (Statement st = con.createStatement();
	             ResultSet textRs = st.executeQuery(textQuery)) {

	            while (textRs.next()) {
	                Dto_Chat dto = new Dto_Chat();
	                byte[] img = textRs.getBytes(1);
	                String texts = textRs.getString(2);
	                String dates = textRs.getString(3);
	                String usernickname = textRs.getString(4);

	                
	                if (texts != null) {
	                    dto = new Dto_Chat(img, texts, dates, usernickname);
	                 // text가 아니라면 이미지인데 이미지일 때 쿼리
	                } else {
	                    String imageQuery = "SELECT c.userImage, cd.image, date_format(cd.date, '%y.%m.%d %H:%i'), c.nickname "
	                            + "FROM chat_text_detail cd "
	                            + "JOIN chat c ON c.chatid = cd.chatid "
	                            + "JOIN sell s ON s.sellid = c.sellid "
	                            + "JOIN user u ON u.userid = s.userid "
	                            + "AND c.chatid = " + Share.chatid;

	                    try (Statement imageSt = con.createStatement();
	                         ResultSet imageRs = imageSt.executeQuery(imageQuery)) {
	                        if (imageRs.next()) {
	                            byte[] img2 = imageRs.getBytes(1);
	                            byte[] image = imageRs.getBytes(2);
	                            String date2 = imageRs.getString(3);
	                            String usernickname2 = imageRs.getString(4);

	                            dto = new Dto_Chat(img2, image, date2, usernickname2);
	                        }
	                    }
	                }
	                dtoList.add(dto);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return dtoList;
	}
	
	// 챗 카운트 
	public int findChatCount() {
		int chatCoun = 0;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        Statement st = con.createStatement();
	        
	        String query = "SELECT count(*) "
	        		+ "	                FROM chat_text_detail cd "
	        		+ "	                JOIN chat c ON c.chatid = cd.chatid "
	        		+ "	                JOIN sell s ON s.sellid = c.sellid "
	        		+ "	                JOIN user u ON u.userid = s.userid "
	        		+ "	                AND c.chatid = " + Share.chatid;
	        
	        ResultSet rs = st.executeQuery(query);
	        if(rs.next()) {
	        	chatCoun = rs.getInt(1);
	        }
	        con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return chatCoun;
	}
	
	// chat detail 유저 정보 찾기
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public void findChatDetailUserId() {
		ArrayList<Dto_Chat> dtoList = new ArrayList<Dto_Chat>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select text, date, userid "
					+ "from chat_text_detail "
					+ "where chatid = " + Share.chatid;
			
			ResultSet rs = st.executeQuery(query);
			System.out.println(Share.chatid);
			while(rs.next()) {
				System.out.println("right");
				Dto_Chat dto = new Dto_Chat(rs.getString(1));
				dtoList.add(dto);
				System.out.println(dtoList);
			}
			
			con.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Dto_Chat> findUserImageId() {
		List<Dto_Chat> dL = new ArrayList<Dto_Chat>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select distinct(u.profile_image), s.userid "
					+ "from sell s "
					+ "join user u on s.userid = u.userid "
					+ "where sellid = " + Share.sellId;
			
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				byte[] profileImage = rs.getBytes(1);
				String uid = rs.getString(2);
				Dto_Chat dto = new Dto_Chat(profileImage, uid);
				
				dL.add(dto);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dL;
	}
	
	// block search user
	public boolean searchBlock() {
		boolean check = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select userid, block_user from block_list "
					+ "where userid = '" + Share.id + "' and block_user = '" + Share.checkUser + "'";
					
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				check = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	// update
	
	public void updateChatRoom(String title) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String query = "update chat set title = ?, date = now() where chatid = " + Share.chatid;
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, title);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// delete chat 삭제
	public void deleteChat(int chatId) {
		
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String query = "Delete from chat where chatid = '" + chatId + "'";
			
			ps = con.prepareStatement(query);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
