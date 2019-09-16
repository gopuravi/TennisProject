package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.TournamentRepository;


@Component
public class TournamentDaoImpl {
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
}
