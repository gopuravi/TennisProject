package com.citi.report.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "REPORT_DATA_SOURCES")
public class ReportDataSource {
	
	@JsonIgnore
	@Column(name = "CONNECTION_ID")
	private String connectionId;
	
	@Id 
	@Column(name = "REPORT_INTERNAL_ID",nullable=false)
	private int reportInternalId;
	
	@Column(name = "CREATED_BY")
	private String createdUser;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "DISPLAY_NAME")
	private String displayName;
	
	@Column(name = "DISPLAY_ORDER")
	private int displayOrder;
	
	@Column(name = "FL_DELETED")
	private int isDeleted;
	
	@Column(name = "REPORT_DESCRIPTION")
	private String reportDescription;
	
	@Column(name = "REPORT_IDENTIFIER")
	private String reportIdentifier;
	
	@Column(name = "VIEW_NAME")
	private String viewName;
	
	@OneToMany(mappedBy = "reportDataSource" ,
	        orphanRemoval = true)
	private List<ReportDataFields> reportDataFields;
	
	public ReportDataSource() {}
	
	public ReportDataSource(String connectionId, String createdUser, Date createdDate, String displayName,
			int displayOrder, int isDeleted, String reportDescription, String reportIdentifier, int reportInternalId,
			String viewName) {
		 

		super();
		this.connectionId = connectionId;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.displayName = displayName;
		this.displayOrder = displayOrder;
		this.isDeleted = isDeleted;
		this.reportDescription = reportDescription;
		this.reportIdentifier = reportIdentifier;
		this.reportInternalId = reportInternalId;
		this.viewName = viewName;
	}
	
	@Override
	public String toString() {
		return "ReportDataSource [connectionId=" + connectionId + ", createdUser=" + createdUser + ", createdDate="
				+ createdDate + ", displayName=" + displayName + ", displayOrder=" + displayOrder + ", isDeleted="
				+ isDeleted + ", reportDescription=" + reportDescription + ", reportIdentifier=" + reportIdentifier
				+ ", reportInternalId=" + reportInternalId + ", viewName=" + viewName + "]";
	}
	public String getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public int isDeleted() {
		return isDeleted;
	}
	public void setDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getReportDescription() {
		return reportDescription;
	}
	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}
	public String getReportIdentifier() {
		return reportIdentifier;
	}
	public void setReportIdentifier(String reportIdentifier) {
		this.reportIdentifier = reportIdentifier;
	}
	public int getReportInternalId() {
		return reportInternalId;
	}
	public void setReportInternalId(int reportInternalId) {
		this.reportInternalId = reportInternalId;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	

}
