package com.upog.tennis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.upog.tennis.dao.ReportsDaoImpl;
import com.upog.tennis.exception.ResponeException;

import com.upog.tennis.util.Constant;
import com.upog.tennis.util.Util; 

@Component
public class TennisService {
	
	

	@Autowired
	ReportsDaoImpl reportsDaoImpl;
	

	public List<List<Map<String,Object>>> getDynamicReport(String connectionName,String dynamicReportSQL) throws ResponeException{
		try {
		return reportsDaoImpl.getDynamicReport(connectionName,dynamicReportSQL);
		}catch (Exception e) {
			throw new ResponeException(e);
		}
	}
	
	
}
