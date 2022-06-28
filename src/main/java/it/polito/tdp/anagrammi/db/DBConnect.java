package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	static private final String url = "jdbc:mysql://localhost:3306/dizionario?user=root&password=root";
	
	public static Connection getConnection() {
		
		try {
			Connection connection = DriverManager.getConnection(url);
			return connection;
		} catch (SQLException e) {
			System.err.println("Errore di connessione!");
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection" + url, e);
		}
	}
}
