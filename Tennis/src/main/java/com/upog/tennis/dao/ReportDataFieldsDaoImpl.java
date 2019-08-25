package com.upog.tennis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.ReportDataFields;
import com.upog.tennis.repository.ReportDataFieldsRepository;


@Component
public class ReportDataFieldsDaoImpl {
	
	@Autowired
	private ReportDataFieldsRepository reportDataFieldsRepository;
	
	
	public List<ReportDataFields> retrieveAllFields(){
		return reportDataFieldsRepository.findAll();
		
	}
	
	
	public List<ReportDataFields> retrieveFieldsbyReportId( int reportInternalId){
		return reportDataFieldsRepository.retrieveFieldsbyReportId(reportInternalId);
		
	}
	
	public List<ReportDataFields> retrieveFieldsbyReportName( String reportName){
		return reportDataFieldsRepository.retrieveFieldsbyReportName(reportName);
		
	}

}
