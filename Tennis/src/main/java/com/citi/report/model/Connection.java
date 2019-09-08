package com.citi.report.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONNECTION_DETAILS")
public class Connection {
	@Id 
	@Column(name = "CONNECTION_ID")
	int connectionId;
	@Column(name = "CONNECTION_NAME")
	String connectionName;
	@Column(name = "COMMENTS")
	String comments;
	@Column(name = "JDBC_URL")
	String jdbcUrl;
	@Column(name = "USER_ID")
	String userName;

	@Column(name = "SERVICE_NAME")
	String serviceName;
	@Column(name = "ENCRYPTED_PASSWORD")
	String password;
	@Column(name = "DRIVER_NAME")
	String driverName;
	@Column(name = "FL_ACTIVE")
	boolean isActive;
	@Column(name = "HOST_NAME")
	String hostname;
	@Column(name = "PORT_NO")
	int portNo; 

	public Connection() {}
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public int getPortNo() {
		return portNo;
	}
	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}
	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", connectionName=" + connectionName + ", comments="
				+ comments + ", jdbcUrl=" + jdbcUrl + ", userName=" + userName + ", serviceName=" + serviceName
				+ ", password=" + password + ", driverName=" + driverName + ", isActive=" + isActive + ", hostname="
				+ hostname + ", portNo=" + portNo + "]";  
	}


}
