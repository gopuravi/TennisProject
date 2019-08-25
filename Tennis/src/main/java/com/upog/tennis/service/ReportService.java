package com.upog.tennis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.dao.ReportDataFieldsDaoImpl;
import com.upog.tennis.dao.ReportDataSourceDaoImpl;
import com.upog.tennis.dao.ReportsDaoImpl;
import com.upog.tennis.model.ReportDataFields;
import com.upog.tennis.model.ReportDataSource;
import com.upog.tennis.repository.StaticReportRepository;
import com.upog.tennis.util.Constant;

@Component
public class ReportService {
	private static List<ReportDataSource> reportList=new ArrayList<ReportDataSource>();
	
	@Autowired
	ReportDataSourceDaoImpl reportDataSourceDaoImpl;
	@Autowired
	ReportDataFieldsDaoImpl reportDataFieldsDaoImpl;
	@Autowired
	ReportsDaoImpl reportsDaoImpl;

	
	public List<ReportDataSource> getReportList(){
		return reportDataSourceDaoImpl.retrieveAllreports();
	}
	
	public List<ReportDataFields> getReportFields(int reportId){
		return reportDataFieldsDaoImpl.retrieveFieldsbyReportId(reportId);
	}
	
	public List<ReportDataFields> getReportFields(String reportName){
		return reportDataFieldsDaoImpl.retrieveFieldsbyReportName(reportName);
	}
	
	public List<List<Map<String,Object>>> getDynamicReport(String connectionName,String dynamicReportSQL){
		return reportsDaoImpl.getDynamicReport(connectionName,dynamicReportSQL);
	}
	
	public List<List<Map<String,Object>>> getStaticReport(String reportIdentifier){
		List<List<Map<String,Object>>> result=null;
		try 
		{
			List<ReportDataFields> dataFieldList= getReportFields( reportIdentifier);
			ReportDataSource reportDataSource=reportDataSourceDaoImpl.findReportbyName(reportIdentifier);
			StringBuilder Query=new StringBuilder("SELECT ");
			dataFieldList.forEach(dataField -> {
				if(!dataField.isHide())
					Query.append(dataField.getFieldName()).append(Constant.COMMA);
			});
			
			Query.setLength(Query.length()-1);
			Query.append(Constant.SPACE+Constant.FROM+Constant.SPACE+reportDataSource.getViewName()+ " where rownum <101");
			result=reportsDaoImpl.getStaticReport("ANALYZER", Query.toString());
			System.out.println("The Query is " + Query); 
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
}
