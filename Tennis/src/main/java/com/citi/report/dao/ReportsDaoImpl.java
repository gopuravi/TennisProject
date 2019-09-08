package com.citi.report.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.report.repository.DynamicReportRepository;
import com.citi.report.repository.StaticReportRepository;

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
