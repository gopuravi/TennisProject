package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.GameTypeRepository;


@Component
public class GameTypeDaoImpl {
	
	@Autowired
	private GameTypeRepository gameTypeRepository;
	
}
