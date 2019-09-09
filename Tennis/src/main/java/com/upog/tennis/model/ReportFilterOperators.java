package com.upog.tennis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPORT_FILTER_OPERATORS")
public class ReportFilterOperators {
	public ReportFilterOperators() {}
	
	@Id 
	@Column(name = "FILTER_OPR_ID",nullable=false)
	private int filterOprId;
	
	@Column(name = "FILTER_TYPE_ID")
	private int filterTypeId;
	
	@Column(name = "FILTER_OPR_VALUE")
	private String filterOprValue;
	
	@Column(name = "FILTER_OPR_DISPLAY_NAME")
	private String filterOprdisplayName;
	
	@Column(name = "FL_ACTIVE")
	private int isActive; 
	
  
	// @JoinColumn (name="FILTER_TYPE_ID",referencedColumnName="FILTER_TYPE_ID", insertable=false, updatable=false)
	/* @ManyToOne
	  public ReportFilterType reportFilterType;   
	*/
	
  

	public int getFilterOprId() {
		return filterOprId;
	}

	public void setFilterOprId(int filterOprId) {
		this.filterOprId = filterOprId;
	}

	public int getFilterTypeId() {
		return filterTypeId;
	}

	public void setFilterTypeId(int filterTypeId) {
		this.filterTypeId = filterTypeId;
	}

	public String getFilterOprValue() {
		return filterOprValue;
	}

	public void setFilterOprValue(String filterOprValue) {
		this.filterOprValue = filterOprValue;
	}

	public String getFilterOprdisplayName() {
		return filterOprdisplayName;
	}

	public void setFilterOprdisplayName(String filterOprdisplayName) {
		this.filterOprdisplayName = filterOprdisplayName;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	

}
