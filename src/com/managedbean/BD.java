package com.managedbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
	private String myDriver;
	private String myUrl;
	private Connection conn;

	public Connection conectar() throws ClassNotFoundException, SQLException{
		myDriver = "org.gjt.mm.mysql.Driver";
		myUrl = "jdbc:mysql://localhost/dw2";
		Class.forName(myDriver);
		return this.conn = DriverManager.getConnection(myUrl, "root", "apollo87");
	}

	public String getMyDriver() {
		return myDriver;
	}

	public void setMyDriver(String myDriver) {
		this.myDriver = myDriver;
	}

	public String getMyUrl() {
		return myUrl;
	}

	public void setMyUrl(String myUrl) {
		this.myUrl = myUrl;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}