package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.TournamentPlayerDetailsRepository;


@Component
public class TournamentPlayerDetailsDaoImpl {
	
	@Autowired
	private TournamentPlayerDetailsRepository tournamentPlayerDetailsRepository;
	
}
