package com.upog.tennis.dao;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.repository.DynamicReportRepository;
import com.upog.tennis.repository.StaticReportRepository;

@Component
public class ReportsDaoImpl {
	
	@Autowired
	private DynamicReportRepository dynamicReportRepository;
	
	
	@Autowired
	private StaticReportRepository staticReportRepository; 
	
	
	
	
	public List<List<Map<String,Object>>> getDynamicReport(String connectionName,String dynamicReportSQL) {		
		return dynamicReportRepository.getDynamicReport(connectionName,dynamicReportSQL);
	}
	
	public List<List<Map<String,Object>>> getStaticReport(String connectionName,String reportSQL) {		
		return staticReportRepository.getStaticReport(connectionName,reportSQL);
	}
	
	

}
