package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.MatchTypeRepository;


@Component
public class MatchTypeDaoImpl {
	
	@Autowired
	private MatchTypeRepository matchTypeRepository;
	
}
