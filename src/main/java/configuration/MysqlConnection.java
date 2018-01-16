package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnection {
	
	protected static Connection crunchifyConn = null;
	protected static PreparedStatement crunchifyPrepareStat = null;
 
//	public static void main(String[] argv) {
// 
//		try {
//			log("-------- Simple Crunchify Tutorial on how to make JDBC connection to MySQL DB locally on macOS ------------");
//			makeJDBCConnection();
// 
////			log("\n---------- Adding company 'Crunchify LLC' to DB ----------");
////			addDataToDB("Crunchify, LLC.", "NYC, US", 5, "http://crunchify.com");
////			addDataToDB("Google Inc.", "Mountain View, CA, US", 50000, "https://google.com");
////			addDataToDB("Apple Inc.", "Cupertino, CA, US", 30000, "http://apple.com");
//// 
////			log("\n---------- Let's get Data from DB ----------");
////			getDataFromDB();
// 
//			crunchifyPrepareStat.close();
//			crunchifyConn.close(); // connection close
// 
//		} catch (SQLException e) {
// 
//			e.printStackTrace();
//		}
//	}
 
	protected static void makeJDBCConnection() {
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			log("Congrats - Seems your MySQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.
			crunchifyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/go2balkan", "root", "admin");
			if (crunchifyConn != null) {
				log("Connection Successful! Enjoy. Now it's time to push data");
			} else {
				log("Failed to make connection!");
			}
		} catch (SQLException e) {
			log("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
 
	}
 
	private static void addDataToDB(String companyName, String address, int totalEmployee, String webSite) {
 
		try {
			String insertQueryStatement = "INSERT  INTO  Employee  VALUES  (?,?,?,?)";
 
			crunchifyPrepareStat = crunchifyConn.prepareStatement(insertQueryStatement);
			crunchifyPrepareStat.setString(1, companyName);
			crunchifyPrepareStat.setString(2, address);
			crunchifyPrepareStat.setInt(3, totalEmployee);
			crunchifyPrepareStat.setString(4, webSite);
 
			// execute insert SQL statement
			crunchifyPrepareStat.executeUpdate();
			log(companyName + " added successfully");
		} catch (
 
		SQLException e) {
			e.printStackTrace();
		}
	}
 
 
	// Simple log utility
	private static void log(String string) {
		System.out.println(string);
 
	}

}
