package com.upog.tennis.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "REPORT_FILTER_TYPE")
public class ReportFilterType {
	
	public ReportFilterType() {}
	
	@Id 
	@Column(name = "FILTER_TYPE_ID",nullable=false)
	private int filterTypeId;
	
	@Column(name = "FILTER_TYPE")
	private String filterType;
	
	@Column(name = "FILTER_NAME")
	private String filterName;
	
	@Column(name = "FL_ACTIVE")
	private int isActive;
	
	//@OneToMany(mappedBy = "reportFilterType"  )  
	//@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinColumn(name="FILTER_TYPE_ID")
	
	public Set<ReportFilterOperators> reportFilterOperators; 
	

	public int getFilterTypeId() {
		return filterTypeId;
	}

	public void setFilterTypeId(int filterTypeID) {
		this.filterTypeId = filterTypeID;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Set<ReportFilterOperators> getReportFilterOperators() {
		return reportFilterOperators;
	}

	public void setReportFilterOperators(Set<ReportFilterOperators> reportFilterOperators) {
		this.reportFilterOperators = reportFilterOperators;
	}

}
