package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.ScheduleLogicRepository;


@Component
public class ScheduleLogicDaoImpl {
	
	@Autowired
	private ScheduleLogicRepository scheduleLogicRepository;
	
}
