package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao_Write {
	
	//Field
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	String userid;
	String pw;
	
	//Constructor
	
	public Dao_Write() {
		
	}
	public Dto_Write userIdinput() {
		
		Dto_Write dto = null;
		
		//Share.id ="cici16"; //************test
		String where1 = "select userid, pw from user where userid = '"+ Share.id +"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where1);
			
			while(rs.next()) {
				String userid = rs.getString(1);
			//	String pw = rs.getString(2);
			
				dto = new Dto_Write(userid,pw);	
		}
		      
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // 어디서 오류가 났는지 출력
		}

		return dto;
		
    }
	
	public void testing(String userid) {
		
		PreparedStatement ps = null;
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String whare1="where userid = '" + Share.id +"'";
			
			ps = conn_mysql.prepareStatement(whare1);
			ps.setString(1,userid);
			
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // 어디서 오류가 났는지 출력
		}

	}

}
