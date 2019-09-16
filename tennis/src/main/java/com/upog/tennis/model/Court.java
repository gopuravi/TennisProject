package com.upog.tennis.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURT")
public class Court {

	@Id 
	@Column(name = "COURT_ID")
	int id;
	@Column(name = "COURT_NAME")
	String name;
	@Column(name = "ACTIVE")
	boolean isActive;
	@Column(name = "COMMENTS")
	String comments;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURT_TYPE_ID", referencedColumnName = "COURT_TYPE_ID")
    private CourtType courtType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCESS_TYPE_ID", referencedColumnName = "ACCESS_TYPE_ID")
    private AccessType accessType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURT_RATING_ID", referencedColumnName = "COURT_RATING_ID")
    private CourtRating courtRating;

	public Court() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CourtType getCourtType() {
		return courtType;
	}

	public void setCourtType(CourtType courtType) {
		this.courtType = courtType;
	}

	public AccessType getAccessType() {
		return accessType;
	}

	public void setAccessType(AccessType accessType) {
		this.accessType = accessType;
	}

	public CourtRating getCourtRating() {
		return courtRating;
	}

	public void setCourtRating(CourtRating courtRating) {
		this.courtRating = courtRating;
	}

	@Override
	public String toString() {
		return "Court [id=" + id + ", name=" + name + ", isActive=" + isActive + ", comments=" + comments + ", address="
				+ address + ", courtType=" + courtType + ", accessType=" + accessType + ", courtRating=" + courtRating
				+ "]";
	}
	
	
	
	
	
	
	
	
}
