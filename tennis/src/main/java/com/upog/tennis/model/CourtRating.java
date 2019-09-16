package com.upog.tennis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURT_RATING")
public class CourtRating {

	@Id 
	@Column(name = "COURT_RATING_ID")
	int id;
	@Column(name = "COURT_RATING_NAME")
	String name;
	@Column(name = "COURT_RATING_VALUE")
	String value;
	
	public CourtRating() {}

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CourtRating [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

	


}
