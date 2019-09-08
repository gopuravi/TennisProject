package com.citi.report.repository;

import org.springframework.stereotype.Repository;

import com.citi.report.model.ReportDataFields;

import java.util.List;


import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ReportDataFieldsRepository extends JpaRepository<ReportDataFields, Integer>{
	
	@Query("select f from ReportDataFields f where f.reportInternalId = :id order by f.displayOrder")   
    List<ReportDataFields> retrieveFieldsbyReportId(@Param("id") int id);
	
	@Query(value="select F.* from REPORT_DATA_FIELDS F inner join REPORT_DATA_SOURCES s on f.REPORT_INTERNAL_ID=s.REPORT_INTERNAL_ID where s.REPORT_IDENTIFIER = :name ", nativeQuery=true)   
    List<ReportDataFields> retrieveFieldsbyReportIdentifier(@Param("name") String name);
	 
	/* To use Native SQL
	@Query(value="select F.REPORT_FIELDS_INTERNAL_ID,F.REPORT_INTERNAL_ID,F.DISPLAY_NAME,F.DISPLAY_ORDER,F.FIELD_LENGTH,F.FIELD_NAME,F.FIELD_TYPE,F.FL_DEFAULTSORT,F.FL_FILTER,F.FL_HIDE,F.FL_PERIOD from REPORT_DATA_FIELDS f where f.REPORT_INTERNAL_ID = ?1", nativeQuery=true)
    public  List<ReportDataFields> retrieveFieldsbyreportId(int reportInternalId );
    */
	
	 
} 
