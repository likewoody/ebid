package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	// read
	public ArrayList<Dto_Chat> searchChat() {
		ArrayList<Dto_Chat> dtoList = new ArrayList<Dto_Chat>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select img.profile_image, img.nickname, img.title, img.chatid "
					+ "from (select distinct(profile_image), c.nickname, c.title, c.chatid, c.sellid, c.date "
					+ "from chat c, sell s, user u "
					+ "where c.nickname = u.nickname) img "
					+ "left join sell s on s.sellid = img.sellid "
					+ "left join user u on u.userid = s.userid "
					// @@@@@@@@@@@@@@ 아이디 바꿔야함 @@@@@@@@@@@@
					+ "where u.userid = 'joa72' "					// @@@@@@@@@@@@@@ 아이디 바꿔야함 @@@@@@@@@@@@
					// @@@@@@@@@@@@@@ 아이디 바꿔야함 @@@@@@@@@@@@
					+ "order by img.date desc" ;
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				byte[] profile_img = rs.getBytes(1);
				String nick = rs.getString(2);
				String post_title = rs.getString(3);
				int chatId = rs.getInt(4);
//				int date = rs.getInt(6);
				
				Dto_Chat dto = new Dto_Chat(profile_img, nick, post_title, chatId);
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
			
			String query = "select cd.text, cd.date, cd.userid "
					+ "from chat_text_detail cd, chat c "
					+ "where cd.chatid = c.chatid "
					+ "and c.chatid = " + Share.chatid;
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String texts = rs.getString(1);
				String userids = rs.getString(2);
				int dates = rs.getInt(3);
				
				Dto_Chat dto = new Dto_Chat(texts, userids, dates);
				
				dtoList.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	// chat 삭제
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
	
	
	// chat detail 유저 정보 찾기
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public void findChatDetailUserId() {
		ArrayList<Dto_Chat> dtoList = new ArrayList<Dto_Chat>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select distinct(cd.userid) "
					+ "from chat_text_detail cd "
					+ "left join chat c on cd.chatid = c.chatid "
					+ "left join sell s on s.sellid = c.sellid "
					+ "where cd.chatid = " + Share.chatid;
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
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
