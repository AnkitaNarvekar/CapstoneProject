package com.foodbox.helper;

import java.sql.*;

public class DbConnectionProvider {

	public static Connection getCon() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase6-foodbox", "root", "root");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
