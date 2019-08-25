package com.upog.tennis.model;

public class Connection {
	int connectionId;
	String connectionName;
	String connectionDescription;
	String connectionUrl;
	String userName;
	String driver;
	String password;
	
	private Connection() {}
	public Connection(int connectionId, String connectionName) {
		super();
		this.connectionId = connectionId;
		this.connectionName = connectionName;
	}
	
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public String getConnectionName() {
		return connectionName;
	}
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}
	public String getConnectionDescription() {
		return connectionDescription;
	}
	public void setConnectionDescription(String connectionDescription) {
		this.connectionDescription = connectionDescription;
	}
	public String getConnectionUrl() {
		return connectionUrl;
	}
	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
