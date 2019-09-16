package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.ResultTypeRepository;


@Component
public class ResultTypeDaoImpl {
	
	@Autowired
	private ResultTypeRepository resultTypeRepository;
	
}
