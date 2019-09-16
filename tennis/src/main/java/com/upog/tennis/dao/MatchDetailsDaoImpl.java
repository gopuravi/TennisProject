package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.MatchDetailsRepository;


@Component
public class MatchDetailsDaoImpl {
	
	@Autowired
	private MatchDetailsRepository matchDetailsRepository;
	
}
