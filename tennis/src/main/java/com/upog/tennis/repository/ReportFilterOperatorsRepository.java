package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.ReportFilterOperators;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ReportFilterOperatorsRepository extends JpaRepository<ReportFilterOperators, Integer>{
	
	List<ReportFilterOperators> findByFilterTypeId(int filterTypeId);
	

}
