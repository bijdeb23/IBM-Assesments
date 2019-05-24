package com.swiss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {	
	
	Connection dbCon;
	
	Connection connectToDatabase() {
		
		
	try {
		//Load the Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Make the connection
		dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/swissbankdb", "root", "");
		
		//check whether successful
		if(dbCon == null) {
			System.out.println("Some issues while connecting to database...");
		}
		else {
		
			System.out.println("Database Running");
		
		}
		
		
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println("Some issues occured : " + e);
	}
	
	return dbCon;
}

}