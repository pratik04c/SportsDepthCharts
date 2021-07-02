package com.sports.depthchart.model;

public class PlayerModel {
	private Integer playerId;
	private String name;
	private String league;
	private String position;
	private Integer positionDepth;
	
	public Integer getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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

	public Integer getPositionDepth() {
		return positionDepth;
	}

	public void setPositionDepth(Integer positionDepth) {
		this.positionDepth = positionDepth;
	}
}
