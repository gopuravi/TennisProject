package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.PlayerRepository;


@Component
public class PlayerDaoImpl {
	
	@Autowired
	private PlayerRepository playerRepository;
	
}
