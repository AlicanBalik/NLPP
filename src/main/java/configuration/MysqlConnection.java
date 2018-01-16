package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnection {

	protected static Connection ribaConn = null;
	protected static PreparedStatement ribaPrepareStat = null;

	protected static void makeJDBCConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		try {
			ribaConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/go2balkan", "root", "admin");
			if (ribaConn == null)
				log("Failed to make connection!");
		} catch (SQLException e) {
			log("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}

	}

	// Simple log utility -- it's a trick...
	private static void log(String string) {
		System.out.println(string);

	}

}
