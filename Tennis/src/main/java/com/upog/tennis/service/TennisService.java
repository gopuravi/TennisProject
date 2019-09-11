package com.upog.tennis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.dao.ReportDataFieldsDaoImpl;
import com.upog.tennis.dao.ReportDataSourceDaoImpl;
import com.upog.tennis.dao.ReportFilterTypeDaoImpl;
import com.upog.tennis.dao.ReportsDaoImpl;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.ReportDataFields;
import com.upog.tennis.model.ReportDataSource;
import com.upog.tennis.model.ReportFilterType;
import com.upog.tennis.repository.StaticReportRepository;
import com.upog.tennis.util.Constant;
import com.upog.tennis.util.Util;

@Component
public class TennisService {
	private static List<ReportDataSource> reportList=new ArrayList<ReportDataSource>();
	
	@Autowired
	ReportDataSourceDaoImpl reportDataSourceDaoImpl;
	@Autowired
	ReportDataFieldsDaoImpl reportDataFieldsDaoImpl;
	@Autowired
	ReportsDaoImpl reportsDaoImpl;
	
	@Autowired
	ReportFilterTypeDaoImpl reportFilterTypeDaoImpl;

	
	public List<ReportDataSource> getReportList(){
		return reportDataSourceDaoImpl.retrieveAllreports();
	}
	
	public List<ReportDataFields> getReportFields(int reportId){
		return reportDataFieldsDaoImpl.retrieveFieldsbyReportId(reportId);
	}
	
	public List<ReportDataFields> getReportFields(String reportIdentifier){
		return reportDataFieldsDaoImpl.retrieveFieldsbyReportIdentifier(reportIdentifier);
	}
	
	public List<List<Map<String,Object>>> getDynamicReport(String connectionName,String dynamicReportSQL) throws ResponeException{
		try {
		return reportsDaoImpl.getDynamicReport(connectionName,dynamicReportSQL);
		}catch (Exception e) {
			throw new ResponeException(e);
		}
	}
	
	public  Map<String, Map<String,Object> >  getFilterConfig(String reportIdentifier){
		List< Map<String, Map<String,Object> > > filterConfig= new ArrayList();
		 Map<String, Map<String,Object> > configeMap= new HashMap<String, Map<String,Object> >(); 
		List<ReportFilterType> filterTypeList= reportFilterTypeDaoImpl.retrieveAllFilterType();
		
		List<ReportDataFields> dataFieldList= getReportFields( reportIdentifier);
		
		dataFieldList.forEach(dataField -> {
			if(dataField.isFilter()) {
				Map<String,Object> configAttibuteMap= new HashMap<String,Object>();
				
				//System.out.println("Check" +dataField.getFieldName() + " " + dataField.getFieldType()+Util.getOperatorListByName(filterTypeList, dataField.getFieldType()));
				configAttibuteMap.put(Constant.FILER_CONFIG_ATT_NAME, dataField.getDisplayName() ); 
				configAttibuteMap.put(Constant.FILER_CONFIG_ATT_TYPE, dataField.getFieldType().toLowerCase() );
				configAttibuteMap.put(Constant.FILER_CONFIG_ATT_OPERATORS, Util.getOperatorListByName(filterTypeList, dataField.getFieldType()));				
				configeMap.put(dataField.getFieldName(), configAttibuteMap);
				System.out.println("ConfigMap size " + configeMap.size());
								
			}
				
		});
		
		System.out.println("The config Mapr is " + configeMap);
		return configeMap;  
	}
	
	public List<List<Map<String,Object>>> getStaticReport(String reportIdentifier, String data) throws Exception{
		List<List<Map<String,Object>>> result=null;
		try 
		{
			List<ReportFilterType> filterTypeList= reportFilterTypeDaoImpl.retrieveAllFilterType();			
			List<ReportDataFields> dataFieldList= getReportFields( reportIdentifier);
		
			String condition = Util.getFilterConditionFromJsonString(data,dataFieldList,filterTypeList);									
			

			ReportDataSource reportDataSource=reportDataSourceDaoImpl.findReportbyName(reportIdentifier);
			StringBuilder Query=new StringBuilder("SELECT ");
			dataFieldList.forEach(dataField -> {
				if(!dataField.isHide())
				//	System.out.println(dataField);
					Query.append(dataField.getFieldName()).append(Constant.COMMA);
			});
			
			Query.setLength(Query.length()-1);
			condition=Util.isNotNullorEmpty(condition)? condition+ " and ":condition;
			Query.append(Constant.SPACE+Constant.FROM+Constant.SPACE+reportDataSource.getViewName()+ " where " + condition + " rownum <501");
			result=reportsDaoImpl.getStaticReport("ANALYZER", Query.toString());
			//System.out.println("The Query is " + Query); 
			 
		}catch(Exception e) {
			
			throw e;
		}
		return result;
	}
	
	
	
	
}
