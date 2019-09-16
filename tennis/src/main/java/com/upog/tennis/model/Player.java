package com.upog.tennis.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.upog.tennis.model.Media;


import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PLAYER")
public class Player {
	
	@Id 
	@Column(name = "PLAYER_ID")
	int id;
	@Column(name = "USER_NAME")
	String userName;
	@JsonIgnore
	@Column(name = "PASSWORD")
	String password;
	

	@Column(name = "FIRST_NAME")
	String firstName;
	@Column(name = "LAST_NAME")
	String lastName;
	@Column(name = "EMAIL_ID")
	String emailId;
	@Column(name = "PHONE_NO")
	String phoneNo;
	@Column(name = "DESCRIPTION")
	String description;
	
	@Column(name = "LEVEL")
	float level;
	@Column(name = "TOURNAMENT_WON")
	int tournamentWon;
	@Column(name = "REG_MATCH_PLAYED")
	int noOfRegularMatch;
	@Column(name = "REG_MATCH_WON")
	int noOfRegularMatchWon;
	@Column(name = "REG_MATCH_DRAWN")
	int noOfRegularMatchDrawn;
	@Column(name = "TOURNAMENT_MATCH_PLAYED")
	int noOfTournamentMatch;
	@Column(name = "TOURNAMENT_MATCH_WON")
	int noOfTournamentMatchWon;
	@Column(name = "TOURNAMENT_MATCH_DRAWN")
	int noOfTournamentMatchDrawn;
	@Column(name = "RAITNG")
	float rating;
	@Column(name = "TOURNAMENT_RAITNG")
	float tournamentRating;


	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SEX_NAME", referencedColumnName = "SEX_NAME")
    private Sex sex;
	
	//@OneToMany ( mappedby = "media.strObjectGUID"    )
	
	@OneToMany
	@Formula("SELECT * FROM MEDIA WHERE MEDIA_ID = MEDIA_ID")
	private List<Media> media= new ArrayList<Media>();
	
	
	public Player() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getLevel() {
		return level;
	}


	public void setLevel(float level) {
		this.level = level;
	}


	public int getTournamentWon() {
		return tournamentWon;
	}


	public void setTournamentWon(int tournamentWon) {
		this.tournamentWon = tournamentWon;
	}


	public int getNoOfRegularMatch() {
		return noOfRegularMatch;
	}


	public void setNoOfRegularMatch(int noOfRegularMatch) {
		this.noOfRegularMatch = noOfRegularMatch;
	}


	public int getNoOfRegularMatchWon() {
		return noOfRegularMatchWon;
	}


	public void setNoOfRegularMatchWon(int noOfRegularMatchWon) {
		this.noOfRegularMatchWon = noOfRegularMatchWon;
	}


	public int getNoOfRegularMatchDrawn() {
		return noOfRegularMatchDrawn;
	}


	public void setNoOfRegularMatchDrawn(int noOfRegularMatchDrawn) {
		this.noOfRegularMatchDrawn = noOfRegularMatchDrawn;
	}


	public int getNoOfTournamentMatch() {
		return noOfTournamentMatch;
	}


	public void setNoOfTournamentMatch(int noOfTournamentMatch) {
		this.noOfTournamentMatch = noOfTournamentMatch;
	}


	public int getNoOfTournamentMatchWon() {
		return noOfTournamentMatchWon;
	}


	public void setNoOfTournamentMatchWon(int noOfTournamentMatchWon) {
		this.noOfTournamentMatchWon = noOfTournamentMatchWon;
	}


	public int getNoOfTournamentMatchDrawn() {
		return noOfTournamentMatchDrawn;
	}


	public void setNoOfTournamentMatchDrawn(int noOfTournamentMatchDrawn) {
		this.noOfTournamentMatchDrawn = noOfTournamentMatchDrawn;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public float getTournamentRating() {
		return tournamentRating;
	}


	public void setTournamentRating(float tournamentRating) {
		this.tournamentRating = tournamentRating;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Sex getSex() {
		return sex;
	}


	public void setSex(Sex sex) {
		this.sex = sex;
	}


	public List<Media> getMedia() {
		return media;
	}


	public void setMedia(List<Media> media) {
		this.media = media;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", description="
				+ description + ", level=" + level + ", tournamentWon=" + tournamentWon + ", noOfRegularMatch="
				+ noOfRegularMatch + ", noOfRegularMatchWon=" + noOfRegularMatchWon + ", noOfRegularMatchDrawn="
				+ noOfRegularMatchDrawn + ", noOfTournamentMatch=" + noOfTournamentMatch + ", noOfTournamentMatchWon="
				+ noOfTournamentMatchWon + ", noOfTournamentMatchDrawn=" + noOfTournamentMatchDrawn + ", rating="
				+ rating + ", tournamentRating=" + tournamentRating + ", address=" + address + ", sex=" + sex
				+ ", media=" + media + "]";
	}

	

}
