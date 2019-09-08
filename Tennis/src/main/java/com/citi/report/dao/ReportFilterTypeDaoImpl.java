package com.citi.report.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.report.model.ReportFilterType;
import com.citi.report.repository.ReportFilterTypeRepository;

@Component
public class ReportFilterTypeDaoImpl {
	
	@Autowired
	private ReportFilterTypeRepository reportFilterTypeRepository;
	
	
	public List<ReportFilterType> retrieveAllFilterType(){
		List<ReportFilterType>  reportFilterTypeList= reportFilterTypeRepository.findAll();

		return reportFilterTypeList;  
	}
	
	public ReportFilterType retrieveByFilterType(String filterType){
		return reportFilterTypeRepository.findByFilterType(filterType);	
	}
	
	public ReportFilterType retrieveByFilterName(String filterName){
		return reportFilterTypeRepository.findByFilterName(filterName);	
	}

}