package com.citi.report.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.report.model.Connection;
import com.citi.report.repository.ConnectionRepository;

@Component
public class ConnectionDaoImpl {
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	public List<Connection> retrieveAllConnection(){
		return connectionRepository.findAll();
	} 

}
