package com.upog.tennis.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCORE")
public class Score {

	@Id 
	@Column(name = "SCORE_ID")
	int id;
	@Column(name = "WINNER_SET1_SCORE")
	int winnerSet1Score;
	@Column(name = "RUNNER_SET1_SCORE")
	int runnerSet1Score;
	@Column(name = "DURATION_SET1_MINS")
	int durationSet1Mins;
	@Column(name = "WINNER_SET2_SCORE")
	int winnerSet2Score;
	@Column(name = "RUNNER_SET2_SCORE")
	int runnerSet2Score;
	@Column(name = "DURATION_SET2_MINS")
	int durationSet2Mins;
	@Column(name = "WINNER_SET3_SCORE")
	int winnerSet3Score;
	@Column(name = "RUNNER_SET3_SCORE")
	int runnerSet3Score;
	@Column(name = "DURATION_SET3_MINS")
	int durationSet3Mins;
	@Column(name = "WINNER_SET4_SCORE")
	int winnerSet4Score;
	@Column(name = "RUNNER_SET4_SCORE")
	int runnerSet4Score;
	@Column(name = "DURATION_SET4_MINS")
	int durationSet4Mins;
	@Column(name = "WINNER_SET5_SCORE")
	int winnerSet5Score;
	@Column(name = "RUNNER_SET5_SCORE")
	int runnerSet5Score;
	@Column(name = "DURATION_SET5_MINS")
	int durationSet5Mins;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WINNER_PLAYER_ID", referencedColumnName = "PLAYER_ID")
    private Player winnerPlayer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RUNNER_PLAYER_ID", referencedColumnName = "PLAYER_ID")
    private Player runnerPlayer;
	
	public Score() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWinnerSet1Score() {
		return winnerSet1Score;
	}

	public void setWinnerSet1Score(int winnerSet1Score) {
		this.winnerSet1Score = winnerSet1Score;
	}

	public int getRunnerSet1Score() {
		return runnerSet1Score;
	}

	public void setRunnerSet1Score(int runnerSet1Score) {
		this.runnerSet1Score = runnerSet1Score;
	}

	public int getDurationSet1Mins() {
		return durationSet1Mins;
	}

	public void setDurationSet1Mins(int durationSet1Mins) {
		this.durationSet1Mins = durationSet1Mins;
	}

	public int getWinnerSet2Score() {
		return winnerSet2Score;
	}

	public void setWinnerSet2Score(int winnerSet2Score) {
		this.winnerSet2Score = winnerSet2Score;
	}

	public int getRunnerSet2Score() {
		return runnerSet2Score;
	}

	public void setRunnerSet2Score(int runnerSet2Score) {
		this.runnerSet2Score = runnerSet2Score;
	}

	public int getDurationSet2Mins() {
		return durationSet2Mins;
	}

	public void setDurationSet2Mins(int durationSet2Mins) {
		this.durationSet2Mins = durationSet2Mins;
	}

	public int getWinnerSet3Score() {
		return winnerSet3Score;
	}

	public void setWinnerSet3Score(int winnerSet3Score) {
		this.winnerSet3Score = winnerSet3Score;
	}

	public int getRunnerSet3Score() {
		return runnerSet3Score;
	}

	public void setRunnerSet3Score(int runnerSet3Score) {
		this.runnerSet3Score = runnerSet3Score;
	}

	public int getDurationSet3Mins() {
		return durationSet3Mins;
	}

	public void setDurationSet3Mins(int durationSet3Mins) {
		this.durationSet3Mins = durationSet3Mins;
	}

	public int getWinnerSet4Score() {
		return winnerSet4Score;
	}

	public void setWinnerSet4Score(int winnerSet4Score) {
		this.winnerSet4Score = winnerSet4Score;
	}

	public int getRunnerSet4Score() {
		return runnerSet4Score;
	}

	public void setRunnerSet4Score(int runnerSet4Score) {
		this.runnerSet4Score = runnerSet4Score;
	}

	public int getDurationSet4Mins() {
		return durationSet4Mins;
	}

	public void setDurationSet4Mins(int durationSet4Mins) {
		this.durationSet4Mins = durationSet4Mins;
	}

	public int getWinnerSet5Score() {
		return winnerSet5Score;
	}

	public void setWinnerSet5Score(int winnerSet5Score) {
		this.winnerSet5Score = winnerSet5Score;
	}

	public int getRunnerSet5Score() {
		return runnerSet5Score;
	}

	public void setRunnerSet5Score(int runnerSet5Score) {
		this.runnerSet5Score = runnerSet5Score;
	}

	public int getDurationSet5Mins() {
		return durationSet5Mins;
	}

	public void setDurationSet5Mins(int durationSet5Mins) {
		this.durationSet5Mins = durationSet5Mins;
	}

	public Player getWinnerPlayer() {
		return winnerPlayer;
	}

	public void setWinnerPlayer(Player winnerPlayer) {
		this.winnerPlayer = winnerPlayer;
	}

	public Player getRunnerPlayer() {
		return runnerPlayer;
	}

	public void setRunnerPlayer(Player runnerPlayer) {
		this.runnerPlayer = runnerPlayer;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", winnerSet1Score=" + winnerSet1Score + ", runnerSet1Score=" + runnerSet1Score
				+ ", durationSet1Mins=" + durationSet1Mins + ", winnerSet2Score=" + winnerSet2Score
				+ ", runnerSet2Score=" + runnerSet2Score + ", durationSet2Mins=" + durationSet2Mins
				+ ", winnerSet3Score=" + winnerSet3Score + ", runnerSet3Score=" + runnerSet3Score
				+ ", durationSet3Mins=" + durationSet3Mins + ", winnerSet4Score=" + winnerSet4Score
				+ ", runnerSet4Score=" + runnerSet4Score + ", durationSet4Mins=" + durationSet4Mins
				+ ", winnerSet5Score=" + winnerSet5Score + ", runnerSet5Score=" + runnerSet5Score
				+ ", durationSet5Mins=" + durationSet5Mins + ", winnerPlayer=" + winnerPlayer + ", runnerPlayer="
				+ runnerPlayer + "]";
	}

	
	
}
