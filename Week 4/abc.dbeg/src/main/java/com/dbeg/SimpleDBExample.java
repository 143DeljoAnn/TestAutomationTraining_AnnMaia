package com.dbeg;

//Java program to set up connection and get all data from table
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleDBExample {
	public static void main(String arg[]) {
		Connection connection = null;
		try {
			// below two lines are used for connectivity.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sept2",
			// "root", "pass@word1");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sept2", "root", "pass@word1");

			// mydb is database
			// mydbuser is name of database
			// mydbuser is password of database

			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery("select * from messages where pname like '%11%'");
			int code;
			String name, msg, ptype;
			while (resultSet.next()) {
				code = resultSet.getInt("id");
				name = resultSet.getString("pname").trim();
				msg = resultSet.getString("msg").trim();
				ptype = resultSet.getString("ptype");
				System.out.println("Code : " + code + " Name : " + name + " Message: " + msg + " Ptype: " + ptype);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	} // function ends
} // class ends
