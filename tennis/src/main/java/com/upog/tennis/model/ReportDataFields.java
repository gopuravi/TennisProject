package com.upog.tennis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.upog.tennis.model.ReportDataSource;

@Entity
@Table(name = "REPORT_DATA_FIELDS") 
public class ReportDataFields {
	
	
	@Column(name = "REPORT_INTERNAL_ID")
	private int reportInternalId;
	
	@Id 
	@Column(name = "REPORT_FIELDS_INTERNAL_ID")
	private int reportFieldInternalId;
	
	@Column(name = "DISPLAY_NAME")
	private String displayName;
	
	@Column(name = "FIELD_NAME")
	private String fieldName;
	
	@Column(name = "FIELD_TYPE")
	private String fieldType;
	
	@Column(name = "DISPLAY_ORDER")
	private int displayOrder;
	
	@Column(name = "FIELD_LENGTH")
	private int fieldLength;
	
	@Column(name = "FL_DEFAULTSORT")
	private boolean defaultSort;
	
	@Column(name = "FL_FILTER")
	private boolean isFilter;
	
	@Column(name = "FL_HIDE")
	private boolean isHide;
	
	@Column(name = "FL_PERIOD")
	private boolean isPeriod;
	
	 @ManyToOne(fetch=FetchType.LAZY,optional=false)
	 @JoinColumn (name="REPORT_INTERNAL_ID",referencedColumnName="REPORT_INTERNAL_ID", insertable=false, updatable=false)
	  public ReportDataSource reportDataSource; 
	
	

	public int getReportInternalId() {
		return reportInternalId;
	}

	public void setReportInternalId(int reportInternalId) {
		this.reportInternalId = reportInternalId;
	}

	public int getReportFieldInternalId() {
		return reportFieldInternalId;
	}

	public void setReportFieldInternalId(int reportFieldInternalId) {
		this.reportFieldInternalId = reportFieldInternalId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public int getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(int fieldLength) {
		this.fieldLength = fieldLength;
	}

	public boolean isDefaultSort() {
		return defaultSort;
	}

	public void setDefaultSort(boolean defaultSort) {
		this.defaultSort = defaultSort;
	}

	public boolean isFilter() {
		return isFilter;
	}

	public void setFilter(boolean isFilter) {
		this.isFilter = isFilter;
	}

	public boolean isHide() {
		return isHide;
	}

	public void setHide(boolean isHide) {
		this.isHide = isHide;
	}

	public boolean isPeriod() {
		return isPeriod;
	}

	public void setPeriod(boolean isPeriod) {
		this.isPeriod = isPeriod;
	}

	@Override
	public String toString() {
		return "ReportDataFields [reportInternalId=" + reportInternalId + ", reportFieldInternalId="
				+ reportFieldInternalId + ", displayName=" + displayName + ", fieldName=" + fieldName + ", fieldType="
				+ fieldType + ", displayOrder=" + displayOrder + ", fieldLength=" + fieldLength + ", defaultSort="
				+ defaultSort + ", isFilter=" + isFilter + ", isHide=" + isHide + ", isPeriod=" + isPeriod + "]";
	}

	public ReportDataFields() {}
	public ReportDataFields(int reportInternalId, int reportFieldInternalId, String displayName, String fieldName,
			String fieldType, int displayOrder, int fieldLength, boolean defaultSort, boolean isFilter, boolean isHide,
			boolean isPeriod) {
		super();
		this.reportInternalId = reportInternalId;
		this.reportFieldInternalId = reportFieldInternalId;
		this.displayName = displayName;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.displayOrder = displayOrder;
		this.fieldLength = fieldLength;
		this.defaultSort = defaultSort;
		this.isFilter = isFilter;
		this.isHide = isHide;
		this.isPeriod = isPeriod;
	}
	
	

}
