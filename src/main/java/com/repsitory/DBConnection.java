package com.repsitory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	protected Connection con;

	DBConnection()
	 {
		 try {
	                Class.forName("com.mysql.cj.jdbc.Driver");

	                con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/compdb",
	                    "root",
	                    "Ankit@07"
	                );

	                System.out.println("DB Connected");
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		   
}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}


}
