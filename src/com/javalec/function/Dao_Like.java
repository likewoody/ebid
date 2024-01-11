package com.javalec.function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_Like {

	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;

	public Dao_Like() {

	}

	public ArrayList<Dto_Like> searchDB() {
		ArrayList<Dto_Like> dtoList = new ArrayList<Dto_Like>();
		Dto_Like dto = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();

			String query = "SELECT p.postid, p.post_status, p.title, p.price, u.nickname, MAX(i.imageid) AS max_imageid, "
					+ "(SELECT post_image FROM image WHERE imageid = MAX(i.imageid)) AS max_post_image "
					+ "FROM  post AS p\n" + "JOIN wish_list AS w ON w.postid = p.postid "
					+ "JOIN sell AS s ON s.postid = p.postid\n" + "JOIN user AS u ON s.userid = u.userid "
					+ "JOIN image AS i ON i.postid = p.postid\n" + "WHERE w.userid = '" + Share.id + "' "
					+ "GROUP BY p.postid, p.post_status, p.title, p.price, u.nickname;";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				int postid = rs.getInt(1);
				String post_status = rs.getString(2);
				String title = rs.getString(3);
				int price = rs.getInt(4);
				String nickname = rs.getString(5);

				dto = new Dto_Like(postid, post_status, title, price, nickname);

				dtoList.add(dto);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public ArrayList<Dto_Like> searchlike() {
		ArrayList<Dto_Like> dtoList = new ArrayList<Dto_Like>();
		Dto_Like dto = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();

			String query = "";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				int postid = rs.getInt(1);
				String post_status = rs.getString(2);
				String title = rs.getString(3);
				int price = rs.getInt(4);
				String nickname = rs.getString(5);

				dto = new Dto_Like(postid, post_status, title, price, nickname);

				dtoList.add(dto);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void deleteLike(int like) {
		PreparedStatement ps = null;
		String A = "DELETE FROM wish_list where postid = '" + like + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			ps = con.prepareStatement(A);

			ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
