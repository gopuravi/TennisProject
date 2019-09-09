package com.upog.tennis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.dao.ConnectionDaoImpl;
import com.upog.tennis.dao.ReportFilterOperatorsDaoImpl;
import com.upog.tennis.dao.ReportFilterTypeDaoImpl;
import com.upog.tennis.model.Connection;
import com.upog.tennis.model.ReportDataSource;
import com.upog.tennis.model.ReportFilterOperators;    
import com.upog.tennis.model.ReportFilterType; 
import com.upog.tennis.util.DataSourceFactory; 

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
