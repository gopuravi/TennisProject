package com.upog.tennis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.ReportFilterOperators;
import com.upog.tennis.model.ReportFilterType;
import com.upog.tennis.repository.ReportFilterOperatorsRepository;
import com.upog.tennis.repository.ReportFilterTypeRepository;

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
