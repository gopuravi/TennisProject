package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.ScoreRepository;


@Component
public class ScoreDaoImpl {
	
	@Autowired
	private ScoreRepository scoreRepository;
	
}
