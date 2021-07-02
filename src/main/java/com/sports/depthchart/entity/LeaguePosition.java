package com.sports.depthchart.entity;

public class LeaguePosition {

	private String league;
	private String position;
	
	public LeaguePosition(String league, String position) {
		super();
		this.league = league;
		this.position = position;
	}
	
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "\n[" + league + ":" + position + "]";
	}
	
	@Override
	public int hashCode() {
		return (this.league + this.position).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        LeaguePosition leaguePosition = (LeaguePosition) obj;
        return (leaguePosition.league.equals(this.league)  && leaguePosition.position.equals(this.position));
	}

	
}
