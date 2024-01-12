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

			String query = "SELECT max_image.post_image, p.title, p.price, u.nickname, p.post_status, p.postid, s.sellid, "
					+ "    (SELECT COUNT(w.postid) FROM wish_list w WHERE w.postid = p.postid) AS wish_list_count, "
					+ "    (SELECT COUNT(c.sellid) FROM chat c "
					+ "     JOIN sell s ON c.sellid = s.sellid "
					+ "     JOIN post p ON s.postid = p.postid "
					+ "     WHERE p.postid = max_image.postid) AS chat_count "
					+ "FROM "
					+ "    (SELECT MAX(i.post_image) AS post_image, p.postid "
					+ "     FROM image i "
					+ "     JOIN post p ON p.postid = i.postid "
					+ "     LEFT JOIN sell s ON s.postid = p.postid "
					+ "     GROUP BY p.postid) max_image "
					+ "LEFT JOIN post p ON max_image.postid = p.postid "
					+ "LEFT JOIN sell s ON s.postid = p.postid "
					+ "LEFT JOIN user u ON u.userid = s.userid where u.userid = '" + Share.id + "'";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				dto = new Dto_MyProduct(rs.getBytes(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7),rs.getInt(8), rs.getInt(9));

				dtoList.add(dto);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
