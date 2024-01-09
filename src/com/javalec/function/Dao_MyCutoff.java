package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Dao_MyCutoff {
	
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	
	String blockUserName;
	int status;
	
	public Dao_MyCutoff() {
		
	}
	
	public ArrayList<Dto_MyCutoff> selectList() {
		ArrayList<Dto_MyCutoff> dtoList = new ArrayList<Dto_MyCutoff>(); // Dto_Product라는 타입을 가진 ArrayList 생성

		// SQL 구문
		String whereDefault = "select block_user from block_list where userid='"+Share.id+"'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			// 데이터 추가, 수정, 삭제가 아니기에 executeQuery문 사용
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);

			while (rs.next()) {
				String name = rs.getString(1);
				
				Dto_MyCutoff dto = new Dto_MyCutoff(name);
				dtoList.add(dto);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 어디서 오류가 났는지 출력
		}

		return dtoList; // 불러온 데이터가 입력 된 dtoList 리턴
	}
	

}
