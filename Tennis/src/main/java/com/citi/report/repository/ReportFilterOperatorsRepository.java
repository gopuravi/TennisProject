package com.citi.report.repository;

import org.springframework.stereotype.Repository;

import com.citi.report.model.ReportFilterOperators;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ReportFilterOperatorsRepository extends JpaRepository<ReportFilterOperators, Integer>{
	
	List<ReportFilterOperators> findByFilterTypeId(int filterTypeId);
	

}
