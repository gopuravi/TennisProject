package com.upog.tennis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.ReportDataSource;
import com.upog.tennis.repository.ReportDataSourceRepository;

@Component
public class ReportDataSourceDaoImpl {
	
	@Autowired
	private ReportDataSourceRepository reportDataSourceRepository;
	
	 
	
	public List<ReportDataSource> retrieveAllreports(){
		return reportDataSourceRepository.findAll();
	}
	
	public ReportDataSource findReportbyName(String reportIdentifier){
		return reportDataSourceRepository.findByReportIdentifier(reportIdentifier);
	}

}
