package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.MediaRepository;


@Component
public class MediaDaoImpl {
	
	@Autowired
	private MediaRepository mediaRepository;
	
}
