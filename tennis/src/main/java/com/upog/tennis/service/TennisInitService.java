package com.upog.tennis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.dao.ConnectionDaoImpl;

import com.upog.tennis.model.Connection;

import com.upog.tennis.util.DataSourceFactory; 

@Component
public class TennisInitService {
	

	@Autowired
	ConnectionDaoImpl connectionDaoImpl;	
	@Autowired
	DataSourceFactory dataSourceFactory;
	

	
public List<Connection> getConnectionList(){				
		return connectionDaoImpl.retrieveAllConnection(); 
	} 


public boolean initConnections(){
	boolean result = false;
	dataSourceFactory.loadConnection();
	return result;
} 
	
	
	

}
