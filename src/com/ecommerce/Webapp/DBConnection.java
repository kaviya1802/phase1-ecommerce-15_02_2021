package com.ecommerce.Webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	public Connection connection;
	
	//initialize Connection
	public DBConnection(String url,String username, String password) throws SQLException{
			this.connection= DriverManager.getConnection(url,username,password);
	}		
	//Get connection
	public Connection getConnection() {
		return this.connection;
	}
	public void closeConnection() throws SQLException {
		this.connection.close();
	}
		
	}
	
