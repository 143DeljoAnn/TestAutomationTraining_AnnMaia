package com.dbeg;

//Java program to set up connection and get all data from table
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertToDBExample {
	public static void main(String arg[]) {
		Connection connection = null;
		try {
			// below two lines are used for connectivity.
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sept2", "root", "pass@word1");

			// mydb is database
			// mydbuser is name of database
			// mydbuser is password of database

			PreparedStatement ps = connection.prepareStatement("Insert into message values(?,?,?)");

			ps.setInt(1, 4);
			ps.setString(2, "name56");
			ps.setString(3, "some msg");
			int nrecs = ps.executeUpdate();

			System.out.println("Inserted " + nrecs + " successfully");
			ps.close();
			connection.close();
		} catch (Exception exception) {
			System.out.println(exception);
		}
	} // function ends
} // class ends
