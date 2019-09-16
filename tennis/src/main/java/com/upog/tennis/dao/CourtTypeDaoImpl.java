package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.CourtTypeRepository;


@Component
public class CourtTypeDaoImpl {
	
	@Autowired
	private CourtTypeRepository courtTypeRepository;
	
}
