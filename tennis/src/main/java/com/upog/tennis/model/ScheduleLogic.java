package com.upog.tennis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEDULE_LOGIC")
public class ScheduleLogic {

	@Id 
	@Column(name = "SCHEDULE_LOGIC_ID")
	int id;
	@Column(name = "SCHEDULE_LOGIC_NAME")
	String name;
	@Column(name = "SCHEDULE_LOGIC_DISPLAY_NAME")
	String displayName;

	public ScheduleLogic() {}

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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "ScheduleLogic [id=" + id + ", name=" + name + ", displayName=" + displayName + "]";
	}
	
	
	
}
