package com.javalec.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_MyProduct {


	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;

	public Dao_MyProduct() {

	}

	public ArrayList<Dto_MyProduct> searchDB() {
		ArrayList<Dto_MyProduct> dtoList = new ArrayList<Dto_MyProduct>();
		Dto_MyProduct dto = null;

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

				dto = new Dto_MyProduct(postid, post_status, title, price, nickname);

				dtoList.add(dto);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public ArrayList<Dto_MyProduct> LikeDB() {
		ArrayList<Dto_MyProduct> dtoList = new ArrayList<Dto_MyProduct>();
		Dto_MyProduct dto = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();

			String query = "select count(w.wish_status) "
					+ "from post as p, wish_list as w , sell as s , user as u "
					+ "where s.userid = '" + Share.id + "'"
					+ "and w.postid = p.postid "
					+ "and s.userid = u.userid  "
					+ "and s.postid = p.postid  "
					+ "group by p.postid, p.title;";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				dto = new Dto_MyProduct(rs.getInt(1));

				dtoList.add(dto);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public ArrayList<Dto_MyProduct> ChatDB() {
		ArrayList<Dto_MyProduct> dtoList = new ArrayList<Dto_MyProduct>();
		Dto_MyProduct dto = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement st = con.createStatement();

			String query = "SELECT count(c.sellid) as sell_count "
					+ "FROM post AS p "
					+ "JOIN sell AS s ON s.postid = p.postid "
					+ "JOIN user AS u ON s.userid = u.userid "
					+ "JOIN chat AS c ON s.sellid = c.sellid "
					+ "WHERE s.userid = '" + Share.id + "'";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				dto = new Dto_MyProduct(rs.getInt(1));

				dtoList.add(dto);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
