package com.sports.depthchart.service;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.sports.depthchart.entity.LeaguePosition;
import com.sports.depthchart.entity.Player;
import com.sports.depthchart.exception.PlayerNotAvailable;

@Component
public interface DepthChartService {
	
	public LinkedList<Player> addPlayerToDepthChart(Player player, LeaguePosition position, Integer positionDepth);	
	public LinkedList<Player> addPlayerToDepthChart(Player player, LeaguePosition position);	
	public Player removePlayerFromDepthChart(Integer playerId, LeaguePosition position) throws PlayerNotAvailable;	
	public LinkedList<Player> getPlayersUnderPlayerInDepthChart(Integer playerId, LeaguePosition position);	
	public String getFullDepthChart();	
}
