package com.sports.depthchart.entity;

public class Player {
	private Integer playerId;
	private String name;
	
	public Player() {
		super();
	}
	
	public Player(Integer playerId, String name) {
		super();
		this.playerId = playerId;
		this.name = name;
	}
	
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
	
	@Override
	public String toString() {
		return "(ID=" + playerId + ", Name=" + name + ")";
	}
}
