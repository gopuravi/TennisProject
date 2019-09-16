package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.ScheduleRepository;


@Component
public class ScheduleDaoImpl {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
}
