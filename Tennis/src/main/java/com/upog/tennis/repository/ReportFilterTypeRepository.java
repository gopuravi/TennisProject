package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;


import com.upog.tennis.model.ReportFilterType;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface ReportFilterTypeRepository extends JpaRepository<ReportFilterType, Integer>{
	
	List<ReportFilterType> findAll();   
	
	
	ReportFilterType findByFilterType(String filterType);
	ReportFilterType findByFilterName(String filterName);     

}
