package com.dbeg;

//Java program to set up connection and get all data from table
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDBExample {
	public static void main(String arg[]) {
		Connection connection = null;

		try {
			// below two lines are used for connectivity.
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sept2", "root", "pass@word1");

			// mydb is database
			// mydbuser is name of database
			// mydbuser is password of database

			// sql injection
			PreparedStatement ps = connection.prepareStatement("Update messages set ptype =  ? where ptype = ?) ");

			/*
			 * ps.setInt(1, 4); ps.setString(2, "name56"); ps.setString(3, "some msg");
			 */
			ps.setString(1, "I");
			ps.setString(2, "internal");
			int nrecs = ps.executeUpdate();

			System.out.println("Replaced " + nrecs + " records with I");

			ps.setString(1, "E");
			ps.setString(2, "external");
			nrecs = ps.executeUpdate();

			System.out.println("Replaced " + nrecs + " records with E");
			ps.close();
			connection.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	} // function ends
} // class ends
