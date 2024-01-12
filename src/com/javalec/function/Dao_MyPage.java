package com.javalec.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao_MyPage {

	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;

	String userid;
	String pw;
	String phone;
	String email;
	String nickname;
	String join_date;
	String delect_date;

	public Dao_MyPage() {

	}

	public Dto_MyPage insertInfo() {

		Dto_MyPage dto = null;

		String A = "select userid, pw, phone, email, nickname, address, profile_image from user where userid = '"
				+ Share.id + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(A);

			while (rs.next()) {
				String userid = rs.getString(1);
				String pw = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String nickname = rs.getString(5);
				String address = rs.getString(6);

				// file
				Share.filename = Share.filename + 1;
				File file = new File("./" + Share.filename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(7);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				dto = new Dto_MyPage(userid, pw, phone, email, nickname, address);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 어디서 오류가 났는지 출력
		}

		return dto;
	}

	public void updateNick(String nick) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update user set nickname = ? ";
			String B = "where userid = '" + Share.id + "'";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, nick);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateEmail(String email) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update user set email = ? ";
			String B = "where userid = '" + Share.id + "'";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, email);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePw(String pw) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update user set pw = ? ";
			String B = "where userid = '" + Share.id + "'";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, pw);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAddress(String address) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update user set address = ? ";
			String B = "where userid = '" + Share.id + "'";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, address);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateImage(FileInputStream input) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update user set profile_image = ? ";
			String B = "where userid = '" + Share.id + "'";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setBinaryStream(1, input);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
