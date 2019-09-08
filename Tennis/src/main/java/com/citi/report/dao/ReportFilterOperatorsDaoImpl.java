package com.citi.report.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.report.model.ReportFilterOperators;
import com.citi.report.model.ReportFilterType;
import com.citi.report.repository.ReportFilterOperatorsRepository;
import com.citi.report.repository.ReportFilterTypeRepository;

@Component
public class ReportFilterOperatorsDaoImpl {
	
	
	@Autowired
	private ReportFilterOperatorsRepository reportFilterOperatorsRepository;

	public List<ReportFilterOperators> retrieveAllFilterOperatorrs(){
		return reportFilterOperatorsRepository.findAll();
	}
		
	public List<ReportFilterOperators> retrieveFilterOperatorrsByFilterTypeId(int filterId){
		List<ReportFilterOperators> reportFilterOperatorsList= reportFilterOperatorsRepository.findByFilterTypeId(filterId);
		
		return reportFilterOperatorsList;
	}

}
