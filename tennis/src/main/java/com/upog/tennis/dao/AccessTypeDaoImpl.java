package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.AccessTypeRepository;


@Component
public class AccessTypeDaoImpl {
	
	@Autowired
	private AccessTypeRepository accessTypeRepository;
	
}
