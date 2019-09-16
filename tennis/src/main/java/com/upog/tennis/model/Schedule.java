package com.upog.tennis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {

	@Id 
	@Column(name = "SCHEDULE_ID")
	int id;
	 
	@Column(name = "FROM_DATE")
	Date fromDate;
	@Column(name = "TO_DATE")
	Date toDate;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURT_ID", referencedColumnName = "COURT_ID")
    private Court court;
	

	public Schedule() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public Court getCourt() {
		return court;
	}


	public void setCourt(Court court) {
		this.court = court;
	}


	@Override
	public String toString() {
		return "Schedule [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", court=" + court + "]";
	}

	
	
}
