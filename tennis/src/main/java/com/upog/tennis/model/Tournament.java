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
@Table(name = "TOURNAMENT")
public class Tournament {

	@Id 
	@Column(name = "TOURNAMENT_ID")
	int id;
	 
	@Column(name = "PRIZE_1ST")
	int prize1st;
	@Column(name = "PRIZE_2ND")
	int prize2nd;
	@Column(name = "PRIZE_3RD")
	int prize3rd;
	@Column(name = "ENTREE_FEE")
	int entreeFee;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "PLAYER_ID")
    private Player winnerPlayer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RUNNER_ID", referencedColumnName = "PLAYER_ID")
    private Player runnerPlayer;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_LOGIC_ID", referencedColumnName = "SCHEDULE_LOGIC_ID")
    private ScheduleLogic scheduleLogic;
	
	
	public Tournament() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrize1st() {
		return prize1st;
	}


	public void setPrize1st(int prize1st) {
		this.prize1st = prize1st;
	}


	public int getPrize2nd() {
		return prize2nd;
	}


	public void setPrize2nd(int prize2nd) {
		this.prize2nd = prize2nd;
	}


	public int getPrize3rd() {
		return prize3rd;
	}


	public void setPrize3rd(int prize3rd) {
		this.prize3rd = prize3rd;
	}


	public int getEntreeFee() {
		return entreeFee;
	}


	public void setEntreeFee(int entreeFee) {
		this.entreeFee = entreeFee;
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


	public ScheduleLogic getScheduleLogic() {
		return scheduleLogic;
	}


	public void setScheduleLogic(ScheduleLogic scheduleLogic) {
		this.scheduleLogic = scheduleLogic;
	}


	@Override
	public String toString() {
		return "Tournament [id=" + id + ", prize1st=" + prize1st + ", prize2nd=" + prize2nd + ", prize3rd=" + prize3rd
				+ ", entreeFee=" + entreeFee + ", winnerPlayer=" + winnerPlayer + ", runnerPlayer=" + runnerPlayer
				+ ", scheduleLogic=" + scheduleLogic + "]";
	}

	
	
}
