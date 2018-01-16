package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import configuration.MysqlConnection;

public class ReservationDAO extends MysqlConnection {

	public static void getDataFromDB() {
		makeJDBCConnection();
		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT * FROM Accommodation";

			crunchifyPrepareStat = crunchifyConn.prepareStatement(getQueryStatement);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = crunchifyPrepareStat.executeQuery();

			// Let's iterate through the java ResultSet
			while (rs.next()) {
				String name = rs.getString("name");

				// Simply Print the results
				System.out.println("name:" + name);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

	}
}
