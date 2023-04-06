package sql.controllerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Properties;

public class ConnMariaDB {
	public Connection getConnection() {

		System.out.println("-------- MySQL DB JDBC Connection Testing -------");

		try {

			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.err.println("Where is your MySQL DB JDBC Driver?");
			e.printStackTrace();
		}

		Connection connection = null;
		System.out.println("MySQL JDBC Driver Registered!");

		try {

			connection = DriverManager.getConnection(
					"jdbc:mariadb://202.28.34.205:3306/db64011211038", 
					"64011211038", "64011211038");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.err.println("Failed to make connection!");
		}
		
		System.out.println("-------------- Connected to database ------------\n");
//		  LocalTime time = LocalTime.now();
//		StopWatch watch = new StopWatch();
//		System.err.println("------------------------------");
//		System.err.println("Connected to database");
//		System.err.println("------------------------------");
		
		return connection;
		
		
	}
}
