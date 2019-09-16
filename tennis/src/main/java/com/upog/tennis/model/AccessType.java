package com.upog.tennis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCESS_TYPE")
public class AccessType {

	@Id 
	@Column(name = "ACCESS_TYPE_ID")
	int id;
	@Column(name = "ACCESS_TYPE_NAME")
	String name;
	
	public AccessType() {}

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

	@Override
	public String toString() {
		return "AccessType [id=" + id + ", name=" + name + "]";
	}



}
