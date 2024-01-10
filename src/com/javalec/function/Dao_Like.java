package com.javalec.function;

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

			String query = "select p.postid, p.post_status, p.title, p.price, u.nickname "
					+ "from post as p, wish_list as w, user as u, sell as s where w.userid = '" + Share.id + "' "
					+ "and w.postid = p.postid and s.postid = p.postid and s.userid = u.userid";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				dto = new Dto_Like(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

				dtoList.add(dto);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void deleteLike(String like) {
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
