package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.CourtRatingRepository;


@Component
public class CourtRatingDaoImpl {
	
	@Autowired
	private CourtRatingRepository courtRatingRepository;
	
}
