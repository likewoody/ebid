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

			String query = "select p.post_status, p.title, p.price, u.nickname " + "from post as p, sell as s, user as u "
					+ "where s.userid = '" + Share.id + "' and p.postid = s.postid and u.userid = s.userid";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				dto = new Dto_MyProduct(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getString(4));

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
					+ "where s.userid = 'cici16' "
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

}
