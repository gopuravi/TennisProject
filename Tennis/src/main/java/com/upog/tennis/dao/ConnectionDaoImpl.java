package com.upog.tennis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.Connection;
import com.upog.tennis.repository.ConnectionRepository;

@Component
public class ConnectionDaoImpl {
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	public List<Connection> retrieveAllConnection(){
		return connectionRepository.findAll();
	} 

}
