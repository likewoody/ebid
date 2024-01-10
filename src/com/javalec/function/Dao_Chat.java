package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_Chat {
	
	
	// field
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	private byte[] profile_image;
	private String nickname;
	private String title;
	private int chatDate;
	
	
	
	// method
	public ArrayList<Dto_Chat> searchChat() {
		ArrayList<Dto_Chat> dtoList = new ArrayList<Dto_Chat>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement st = con.createStatement();
			
			String query = "select img.profile_image, img.nickname, img.title "
					+ "from (select distinct(profile_image), c.nickname, c.title, c.sellid "
					+ "from chat c, sell s, user u "
					+ "where c.nickname = u.nickname) img "
					+ "left join sell s on s.sellid = img.sellid "
					+ "left join user u on u.userid = s.userid "
					+ "where u.userid = 'joa72'" ;
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				byte[] profile_img = rs.getBytes(1);
				String nick = rs.getString(2);
				String post_title = rs.getString(3);
//				int date = rs.getInt(4);
				
				Dto_Chat dto = new Dto_Chat(profile_img, nick, post_title);
				dtoList.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
}
