package com.sports.depthchart.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.sports.depthchart.entity.LeaguePosition;
import com.sports.depthchart.entity.Player;

@Component
public class DepthChartServiceImpl implements DepthChartService {
	
	public static HashMap<LeaguePosition, LinkedList<Player>> globalPlayerList;
	
	public LinkedList<Player> addPlayerToDepthChart(Player player, LeaguePosition position, Integer positionDepth) {
		LinkedList<Player> lstPlayer = getPlayersInDepthChart(position);
		if(positionDepth > lstPlayer.size()) {
			return null;
		}
		lstPlayer.add(positionDepth, player);
		return lstPlayer;
	}
	
	public LinkedList<Player> addPlayerToDepthChart(Player player, LeaguePosition position) {
		LinkedList<Player> lstPlayer = getPlayersInDepthChart(position);
		lstPlayer.addLast(player);
		return lstPlayer;
	}
	
	public Player removePlayerFromDepthChart(Integer playerId, LeaguePosition position) {
		LinkedList<Player> lstPlayer = (LinkedList<Player>) globalPlayerList.get(position);
		Iterator<Player> itr = lstPlayer.iterator();  
		while(itr.hasNext()) { 
			Player player = itr.next();
			if(player.getPlayerId().equals(playerId)) {					
				lstPlayer.remove(player);
				return player;
			}  
		} 	
		return null;
	}
	
	public LinkedList<Player> getPlayersUnderPlayerInDepthChart(Integer playerId, LeaguePosition position) {
		LinkedList<Player> lstPlayer = (LinkedList<Player>) globalPlayerList.get(position);
		LinkedList<Player> nextPlayer = new LinkedList<Player>();
		Iterator<Player> itr = lstPlayer.iterator();  
		boolean flag = false;
		while(itr.hasNext()) { 
			Player player = itr.next();
			if(flag) {					
				nextPlayer.add(player);
			} else if(player.getPlayerId().equals(playerId)) {					
				flag = true;
			}  
		} 	
		return nextPlayer;
	}
	
	public String getFullDepthChart() {
		Iterator it = globalPlayerList.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        sb.append(pair.getKey() + " = " + pair.getValue());
	    }
	    return sb.toString();
	}
	
	private LinkedList<Player> getPlayersInDepthChart(LeaguePosition position) {
		if(globalPlayerList == null) {
			globalPlayerList = new HashMap<LeaguePosition, LinkedList<Player>>();
			LinkedList<Player> player = new LinkedList<Player>();
			globalPlayerList.put(position, player);
			return player;
		} else {
			LinkedList<Player> player = (LinkedList<Player>) globalPlayerList.get(position);
			if(player == null) {
				player = new LinkedList<Player>();
				globalPlayerList.put(position, player);
			}
			return player;
		}
	}
}
