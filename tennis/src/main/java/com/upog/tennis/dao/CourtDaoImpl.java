package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.CourtRepository;


@Component
public class CourtDaoImpl {
	
	@Autowired
	private CourtRepository courtRepository;
	
}
