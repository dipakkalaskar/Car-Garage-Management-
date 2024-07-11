package org.car.config;
import java.io.*;
import java.sql.*;
import java.util.Properties;

//import javax.swing.plaf.synth.SynthOptionPaneUI;
public class DbConfig {
	
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	private static DbConfig db = null;
	private DbConfig() {
		try {
			
			Properties p = new Properties();
			p.load(PathHelper.fin);
			System.out.println(PathHelper.fin);
			String driverClassName = p.getProperty("driver.classname");
			String username = p.getProperty("db.username");
			String password = p.getProperty("db.password");
			String url = p.getProperty("db.url");
			Class.forName(driverClassName);
//			System.out.println(url+username+password);
			conn= DriverManager.getConnection(url,username,password);
			if (conn!=null) {
				System.out.println("Database Connected");
				
			}
			else {
				System.out.println("Database Not Connected");
			}
		} catch (Exception e) {
			System.out.println("Error is "+e);
			// TODO: handle exception
		}
		
	}
	public static DbConfig getDbInstance() {
		if (db==null) {
			db=new DbConfig();
		}
		return db;
		
	}
	
		
	public static Connection getConnection() {
		return conn;
		
	}
	
	public static PreparedStatement getStatement() {
		return stmt;
		
	}
	public static ResultSet getResultSet() {
		return rs;
		
	}
	

}
