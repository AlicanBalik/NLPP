package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnection {

	protected static Connection crunchifyConn = null;
	protected static PreparedStatement crunchifyPrepareStat = null;

	protected static void makeJDBCConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		try {
			crunchifyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/go2balkan", "root", "admin");
			if (crunchifyConn == null)
				log("Failed to make connection!");
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

			crunchifyPrepareStat.executeUpdate();
			log(companyName + " added successfully");
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	// Simple log utility -- it's a trick...
	private static void log(String string) {
		System.out.println(string);

	}

}
