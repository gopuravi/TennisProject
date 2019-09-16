package com.upog.tennis.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.repository.DynamicReportRepository;


@Component
public class ReportsDaoImpl {
	
	@Autowired
	private DynamicReportRepository dynamicReportRepository;
	
	

	
	public List<List<Map<String,Object>>> getDynamicReport(String connectionName,String dynamicReportSQL) {		
		return dynamicReportRepository.getDynamicReport(connectionName,dynamicReportSQL);
	}
	

	

}
