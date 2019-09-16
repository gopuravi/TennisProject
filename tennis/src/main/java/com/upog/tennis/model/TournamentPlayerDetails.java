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
@Table(name = "TOURNAMENT_PLAYER_DETAILS")
public class TournamentPlayerDetails {

	@Id 
	@Column(name = "TOURNAMENT_PLAYER_ID")
	int id;
	
	@Column(name = "PLAYER_ID")
	int playerId;
	@Column(name = "RANKING")
	int ranking;
	 
	@Column(name = "MATCH_WON")
	int matchWon;
	@Column(name = "MATCH_LOST")
	int matchLost;
	@Column(name = "SET_WON")
	int setWon;
	@Column(name = "SET_LOST")
	int setLost;
	@Column(name = "GAME_WON")
	int gameWon;
	@Column(name = "GAME_LOST")
	int gameLost;
	
	

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYER_ID")
    private Player player;
	
	public TournamentPlayerDetails() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getMatchWon() {
		return matchWon;
	}

	public void setMatchWon(int matchWon) {
		this.matchWon = matchWon;
	}

	public int getMatchLost() {
		return matchLost;
	}

	public void setMatchLost(int matchLost) {
		this.matchLost = matchLost;
	}

	public int getSetWon() {
		return setWon;
	}

	public void setSetWon(int setWon) {
		this.setWon = setWon;
	}

	public int getSetLost() {
		return setLost;
	}

	public void setSetLost(int setLost) {
		this.setLost = setLost;
	}

	public int getGameWon() {
		return gameWon;
	}

	public void setGameWon(int gameWon) {
		this.gameWon = gameWon;
	}

	public int getGameLost() {
		return gameLost;
	}

	public void setGameLost(int gameLost) {
		this.gameLost = gameLost;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "TournamentPlayerDetails [id=" + id + ", playerId=" + playerId + ", ranking=" + ranking + ", matchWon="
				+ matchWon + ", matchLost=" + matchLost + ", setWon=" + setWon + ", setLost=" + setLost + ", gameWon="
				+ gameWon + ", gameLost=" + gameLost + ", player=" + player + "]";
	}

   
	

	
	
}
