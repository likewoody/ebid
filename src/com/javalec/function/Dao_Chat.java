package com.javalec.function;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class Dao_Chat {
	
	
	// field
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	
	// constructor
	public Dao_Chat() {
		// TODO Auto-generated constructor stub
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
//			ps.setString(2, chatText);
			
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
			
//			@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 작동안됨
			String query = "SELECT u.profile_image, c.nickname, c.title, c.date, c.chatid, c.userid, c.selluserid "
					+ "FROM user u "
					+ "LEFT JOIN sell s ON u.userid = s.userid "
					+ "LEFT JOIN chat c ON c.sellid = s.sellid "
					+ "WHERE s.userid = '" + Share.id + "' OR c.userid = '" + Share.id + "'" ;
//			@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 작동안됨
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				byte[] profile_img = rs.getBytes(1);
				String nick = rs.getString(2);
				String post_title = rs.getString(3);
				Date chatDate = rs.getDate(4);
				int chatId = rs.getInt(5);
				String userId = rs.getString(6);
				String sellUserId = rs.getString(7);
//				int date = rs.getInt(6);
				
				Dto_Chat dto = new Dto_Chat(profile_img, nick, post_title, chatDate, chatId, userId, sellUserId);
				dtoList.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// get chat detail
	public ArrayList<Dto_Chat> findChatDeatil() {
		ArrayList<Dto_Chat> dtoList = new ArrayList<Dto_Chat>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select u.profile_image, cd.text, cd.date, cd.userid "
					+ "				from chat_text_detail cd "
					+ "                join chat c on c.chatid = cd.chatid "
					+ "                join sell s on s.sellid = c.sellid "
					+ "                join user u on u.userid = s.userid "
					+ "					and c.chatid =  " + Share.chatid;
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				byte[] img = rs.getBytes(1);
				String texts = rs.getString(2);
				Date dates = rs.getDate(3);
				String userids = rs.getString(4);
				Dto_Chat dto = new Dto_Chat(img, texts, dates, userids);
				
				dtoList.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
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
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	// 클릭한 wish_list의 status를 불러온다.
//	public int findChatUserId() {
//		int Flag = 0;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement st = con.createStatement();
//			
//			String query = "select userid from chat where userid = ;
//			
//			ResultSet rs = st.executeQuery(query);
//			
//			if (rs.next()) {
//				Flag = rs.getInt(1);
//			}
//			con.close();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return Flag;
//	}
}
