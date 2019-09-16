package com.upog.tennis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEX")
public class Sex {

	@Id 
	@Column(name = "SEX_NAME")
	String name;
	@Column(name = "SEX_DISPLAY_NAME")
	String displayName;
	
	public Sex() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "Sex [name=" + name + ", displayName=" + displayName + "]";
	}

	
}
