package com.citi.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.report.dao.ConnectionDaoImpl;
import com.citi.report.dao.ReportFilterOperatorsDaoImpl;
import com.citi.report.dao.ReportFilterTypeDaoImpl;
import com.citi.report.model.Connection;
import com.citi.report.model.ReportDataSource;
import com.citi.report.model.ReportFilterOperators;
import com.citi.report.model.ReportFilterType;
import com.citi.report.util.DataSourceFactory;

@Component
public class ReportInitService {
	
	@Autowired
	ReportFilterTypeDaoImpl reportFilterTypeDaoImpl;
	@Autowired
	ConnectionDaoImpl connectionDaoImpl;	
	@Autowired
	DataSourceFactory dataSourceFactory;
	
	@Autowired
	ReportFilterOperatorsDaoImpl reportFilterOperatorsDaoImpl;
	
	public List<ReportFilterType> getReportFilterType(){
		
		
		return reportFilterTypeDaoImpl.retrieveAllFilterType();
	}
	
public List<Connection> getConnectionList(){				
		return connectionDaoImpl.retrieveAllConnection(); 
	} 


public boolean initConnections(){
	boolean result = false;
	dataSourceFactory.loadConnection();
	return result;
} 
	
	
	
public ReportFilterType getReportFilterByType(){
		return reportFilterTypeDaoImpl.retrieveByFilterType("NUMBER");
	} 

public List<ReportFilterOperators> retrieveFilterOperatorrsByFilterTypeId(int filterTypeId){
		return reportFilterOperatorsDaoImpl.retrieveFilterOperatorrsByFilterTypeId(filterTypeId);
	} 
}
